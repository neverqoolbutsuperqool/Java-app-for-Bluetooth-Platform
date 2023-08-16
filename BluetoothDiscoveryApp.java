import javax.bluetooth.*;
import java.util.Vector;

public class BluetoothDiscoveryApp {

    public static void main(String[] args) {
        try {
            LocalDevice localDevice = LocalDevice.getLocalDevice();

            System.out.println("Local device: " + localDevice.getFriendlyName());
            System.out.println("Device address: " + localDevice.getBluetoothAddress());

            DiscoveryAgent discoveryAgent = localDevice.getDiscoveryAgent();

            DiscoveryListener listener = new DiscoveryListener() {
                public void deviceDiscovered(RemoteDevice remoteDevice, DeviceClass deviceClass) {
                    System.out.println("Discovered device: " + remoteDevice.getBluetoothAddress());
                    try {
                        System.out.println("Device name: " + remoteDevice.getFriendlyName(true));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public void inquiryCompleted(int discType) {
                    System.out.println("Inquiry completed.");
                }

                public void serviceSearchCompleted(int transID, int respCode) {
                    System.out.println("Service search completed.");
                }

                public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                    System.out.println("Services discovered.");
                }
            };

            boolean started = discoveryAgent.startInquiry(DiscoveryAgent.GIAC, listener);

            if (started) {
                System.out.println("Inquiry started. Waiting for devices...");
                Thread.sleep(5000); // Wait for 5 seconds for devices to be discovered
                discoveryAgent.cancelInquiry(listener);
            } else {
                System.out.println("Inquiry could not be started.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
