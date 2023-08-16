# Java-app-for-Bluetooth-Platform
Bluetooth communication in Java can be platform-dependent and might require specific libraries for different operating systems. BlueCove, for instance, works primarily on Windows and Linux. On macOS, you might consider using the Apple's CoreBluetooth framework with JNI (Java Native Interface).

This code snippet completes the Bluetooth discovery application. It starts an inquiry to discover nearby Bluetooth devices, displays their addresses and names, waits for 5 seconds to collect results, and then cancels the inquiry.


**Steps to get Bluetooth application running**

1.Install BlueCove:
Download the BlueCove library for yplatform from the official website: http://bluecove.org/. Follow the installation instructions provided on the website.

2.Set Up Your IDE:
Add the BlueCove library to project's classpath. Add the BlueCove JAR files to project's build path.

3.Compile and Run:
Compile and run the Bluetooth discovery application.

4.Testing:
Run the application and check the output. It should start the Bluetooth discovery process and display the discovered devices' addresses and friendly names.
