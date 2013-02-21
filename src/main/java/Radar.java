public class Radar {

    private int speedLimit;
    private int margin;

    private SensorInterface sensorInterface;
    private CameraInterface cameraInterface;

    public Radar(SensorInterface sensorInterface, CameraInterface cameraInterface)
    {
        this.sensorInterface = sensorInterface;
        this.cameraInterface = cameraInterface;
    }

    public void speedControl()
    {
        if(sensorInterface.getSpeed() <= (this.speedLimit+this.margin))
        {
//            SPEED IS OK - NOTHING TO DO
        }
        else
        {
            cameraInterface.takeFoto();
        }
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }
}
