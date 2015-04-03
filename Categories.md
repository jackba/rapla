Some attributes have only a given set of values, we call them
enumerations. A example is the Operating System
of a notebook: Linux, MaxOS, WinXP, ...

Others have a hierarchical presentation, like the
organisational units of a university: faculty/department

Categories cover both cases.

## Switching the root categories ##

If you change a root category, rapla trys to migrate the categories. It looks for the same keys. So before switching the root category try to change the keynames so rapla can find the same categorie in the new tree.

The follwing changes are supproted

root changes from b to c, when c contains the b substructure including b
```

a
/ \
|b| |c|
/   /
d   b
/
d
```
root changes from b to c when c contains directly the b substructure but not b itself
```

a
/ \
|b| |c|
/   /
d   d
```