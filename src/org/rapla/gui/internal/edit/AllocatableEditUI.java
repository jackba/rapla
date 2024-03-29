/*--------------------------------------------------------------------------*
 | Copyright (C) 2014 Christopher Kohlhaas                                  |
 |                                                                          |
 | This program is free software; you can redistribute it and/or modify     |
 | it under the terms of the GNU General Public License as published by the |
 | Free Software Foundation. A copy of the license has been included with   |
 | these distribution in the COPYING file, if not go to www.fsf.org         |
 |                                                                          |
 | As a special exception, you are granted the permissions to link this     |
 | program with every library, which license fulfills the Open Source       |
 | Definition as published by the Open Source Initiative (OSI).             |
 *--------------------------------------------------------------------------*/
package org.rapla.gui.internal.edit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.rapla.entities.domain.Allocatable;
import org.rapla.entities.domain.Permission;
import org.rapla.entities.domain.ResourceAnnotations;
import org.rapla.entities.dynamictype.internal.DynamicTypeImpl;
import org.rapla.framework.RaplaContext;
import org.rapla.framework.RaplaException;
import org.rapla.gui.EditField;
import org.rapla.gui.internal.edit.fields.BooleanField;
import org.rapla.gui.internal.edit.fields.ClassificationField;
import org.rapla.gui.internal.edit.fields.PermissionListField;
/****************************************************************
 * This is the controller-class for the Resource-Edit-Panel     *
 ****************************************************************/
class AllocatableEditUI  extends AbstractEditUI<Allocatable>  {
    ClassificationField<Allocatable> classificationField;
    PermissionListField permissionField;
    BooleanField holdBackConflictsField;
    boolean internal =false;
    
    public AllocatableEditUI(RaplaContext context, boolean internal) throws RaplaException {
        super(context);
        this.internal = internal;
        ArrayList<EditField> fields = new ArrayList<EditField>();
        classificationField = new ClassificationField<Allocatable>(context);
        fields.add(classificationField );
        permissionField = new PermissionListField(context,getString("permissions"));
        //permissionField.addChangeListener( listener );
        fields.add( permissionField );
        if ( !internal)
        {
            holdBackConflictsField = new BooleanField(context,getString("holdbackconflicts"));
            fields.add(holdBackConflictsField );
        }
        permissionField.setPermissionLevels( Permission.DENIED,  Permission.READ_NO_ALLOCATION, Permission.READ, Permission.ALLOCATE, Permission.ALLOCATE_CONFLICTS, Permission.EDIT, Permission.ADMIN);
        setFields(fields);
    }

    public void mapToObjects() throws RaplaException {
        classificationField.mapTo( objectList);
        permissionField.mapTo( objectList);
        if ( getName(objectList).length() == 0)
            throw new RaplaException(getString("error.no_name"));
        if ( !internal)
        {
            Boolean value = holdBackConflictsField.getValue();
            if ( value != null)
            {
                for ( Allocatable alloc:objectList)
                {
                	alloc.setAnnotation(ResourceAnnotations.KEY_CONFLICT_CREATION, value  ? ResourceAnnotations.VALUE_CONFLICT_CREATION_IGNORE  : null); 
                }
            }
        }
    }

    protected void mapFromObjects() throws RaplaException {
        classificationField.mapFrom( objectList);
        permissionField.mapFrom( objectList);
        Set<Boolean> values = new HashSet<Boolean>();
        boolean canAdmin = true;
        boolean allPermissions = true;
        for ( Allocatable alloc:objectList)
        {
            if ((( DynamicTypeImpl)alloc.getClassification().getType()).isInternal())
            {
                allPermissions = false;
            }
            String annotation = alloc.getAnnotation( ResourceAnnotations.KEY_CONFLICT_CREATION);
			boolean holdBackConflicts = annotation != null && annotation.equals( ResourceAnnotations.VALUE_CONFLICT_CREATION_IGNORE);
			values.add(holdBackConflicts);
			if ( !canAdmin( alloc))
			{
			    canAdmin = false;
			}
        }
        if ( canAdmin == false)
        {
            permissionField.getComponent().setVisible( false );
        }
        if ( allPermissions)
        {
            permissionField.setPermissionLevels( Permission.DENIED,  Permission.READ_NO_ALLOCATION, Permission.READ, Permission.ALLOCATE, Permission.ALLOCATE_CONFLICTS, Permission.EDIT, Permission.ADMIN);
        }
        else
        {
            permissionField.setPermissionLevels( Permission.DENIED,  Permission.READ );
        }
        if ( !internal)
        {   
            if ( values.size() ==  1)
            {
                Boolean singleValue = values.iterator().next();
                holdBackConflictsField.setValue( singleValue);
            }
            if ( values.size() > 1)
            {
                holdBackConflictsField.setFieldForMultipleValues();
            }
        }
        classificationField.setTypeChooserVisible( !internal);
    }



}
