Steps to build rapla in [Eclipse](http://eclipse.org)  (4.2 or higher recommended)

This build instructions refer to the latest version of rapla 1.7beta

## 1a) Creating a new Project from SVN ##
  1. Download install a SVN Plugin for eclipse ([subversive](http://www.eclipse.org/subversive/downloads.php) or [subclipse](http://subclipse.tigris.org/))
  1. click on the "SVN Repository Exploring Perspective" Icon in the left sidebar.
  1. right click in the "perspective" and choose new/repository location url: <br> <code>http://rapla.googlecode.com/svn/</code>
<ol><li>open repository and right-click on trunk<br>
</li><li>select "checkout"<br>
</li><li>click finish, wait for svn and continue with 2.</li></ol>

<h2>1b) Creating a new Project from the src-distribution</h2>

<ol><li>Unzip the source-distribution to a temporary folder<br>
</li><li>Select File/Import/Existing Projects into Workspace<br>
</li><li>choose the rapla-source- folder<br>
</li><li>Click finish<br>
</li><li>Click finish, wait for the import and continue with 2.</li></ol>

<h2>2) Running/Debugging/Testing Rapla directly in eclipse</h2>

<ol><li>You can run/debug Rapla with the run button: select java-application and select the main-class <code>org.rapla.bootstrap.RaplaStandaloneLoader</code>.<br>
</li><li>You can test Rapla by selecting junit and a test from the test-src directory.</li></ol>

<h2>3) Running/Debugging the server</h2>

<ol><li>select <code>org.rapla.bootstrap.RaplaServerLoader</code>
</li><li>Right click and choose <code>run as</code> and then <code>run configurations</code>
</li><li>Click on the new icon<br>
</li><li>Choose run or debug to start the server.<br>
</li><li>Browse to <a href='http://localhost:8051'>http://localhost:8051</a> to check if the server is running<br>
</li><li>The applet and webstart doesnt work here (you need to perform 4 to build a binary-distribution)<br>
</li><li>If you want to test the client start a second procces <code>org.rapla.bootstrap.RaplaClientLoader</code>
</li><li>You can stop the server by switching to the debug perspective and terminating the process (server and client)<br>
</li><li>For debugging choose debug as instead of run as</li></ol>

<h2>4) Building Rapla Version</h2>

<ol><li>Switch to the Java Perspective, right click on the build.xml  and select <code>Run As/Ant Build</code> (The second one)<br>
</li><li>Click on the Refresh-Tab and select <code>Refresh resource upon completion</code> and <code>the project containing the selected resource</code>
</li><li>Click on JRE-Tab and choose run in same JRE as Workspace<br>
</li><li>Now you can press Run to start the build. You find the version in the dist/rapla-binary-{version} folder.<br>
</li><li>Eclipse will create a shortcut to the build process in the toolbar (The green arrow with toolbox). So you can just click <code>Rapla build.xml</code>  to start the build a second time.<br>
</li><li>See <a href='BuildGuide.md'>BuildGuide</a> for more information regarding the build process<br>
</li><li>Build a distribution so so you can test the applet and webstart mode.