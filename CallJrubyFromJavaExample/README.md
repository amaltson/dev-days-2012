Calling Jruby Method From Java Example Project
==============================================

The way this is done is by auto generating java code that is equivalent to the Jruby code you write.
In this example, the MyAdder interface is defined in Java, which is implemented in Jruby (MyAdderImpl.rb).
MyAdderImpl.rb is used to generate the Java version MyAdderImpl.java.
Finally, MyAdderImpl.java is called from MyJrubyCaller.java.

Eclipse Setup
-------------

1. Add jruby.jar to classpath:
	_java project > properties > libraries > add external jars > pick: jruby-1.6.7/lib/jruby.jar_
		
2. Setup an external run tool to convert Jruby code into their Java equivalent files:
	_Run > External Tools > External Tools configuration > New Program_
		Name: Build JRuby to Java Files
		Location: /home/user/.rvm/rubies/jruby-1.6.7/bin/jrubyc
		Working Directory: ${workspace_loc:/MyJavaProject/src}
		Arguments: --java *.rb
	_> Refresh Tab > Check: Refresh resources upon completion_
	_> Apply > Close_
	
To run the project:

1. Run the external program 'Build Jruby to Java Files'
2. Build all the Java code
3. Run MyJrubyCaller