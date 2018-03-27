public class RocketLauncher {
    public static void main(String[] args) {
        do{
            PartInstaller SpaceX = new PartInstaller();
            SpaceX.install();
        }while(ScannerUtil.checkStartApp());
    }
}
