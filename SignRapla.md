# Introduction #

Add your content here.


# Details #

you'll  need a code signing certificate to work for this. Code signing won't work for ssl certifcates. Also notice that not all code certificates are accepted by oracle. The rapla project signs all releases starting from 1.7.7 with a certificate (currently from thawte).

Below is a description, for signing rapla yourself:

First create a keystore in the rapla source root folder e.g. rapla.ks and import your certificte under the alias Rapla. Find the official doc under
http://docs.oracle.com/javase/6/docs/technotes/tools/windows/keytool.html

uncomment and edit build.propterties ( build.properties.template if you have not build rapla yet)
```
#keystore.file=rapla.ks
#keystore.password=secret
```

Then  build rapla with the build script (you may need to set JAVA\_HOME), following [BuildGuide](BuildGuide.md)

If you don't want to sign rapla without building you need to sign all jars in webapp/rapla.war in the webclient folder (unzip/sign jars/zip)
