import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RadarTest {


    Radar radar;
    SensorInterface sensorInterface;
    CameraInterface cameraInterface;

    @Before
    public void beforeTests()
    {
        sensorInterface = mock(SensorInterface.class);
        cameraInterface = mock(CameraInterface.class);
        radar = new Radar(sensorInterface, cameraInterface);
    }

    @Test
    public void testHappyPath() {

//       Given
        radar.setSpeedLimit(50);
        radar.setMargin(10);

//       When
        when(sensorInterface.getSpeed()).thenReturn(55);
        radar.speedControl();

//       Then
        verify(cameraInterface, never()).takeFoto();
    }

    @Test
    public void testSpeedToHigh() {

//       Given
        radar.setSpeedLimit(50);
        radar.setMargin(10);

//       When
        when(sensorInterface.getSpeed()).thenReturn(70);
        radar.speedControl();

//       Then
        verify(cameraInterface, only()).takeFoto();
    }

}
