package RemoteControl;

public class PerformanceStage {
      private static PerformanceStage INSTANCE = null;
      private static int counter;
      private PerformanceStage() {
    	  counter ++;
      }
      
      public synchronized static PerformanceStage getInstance() {
    	  if (INSTANCE == null) {
    		  INSTANCE = new PerformanceStage();
    	  }
    	  return INSTANCE;
      }
      
      public int getCounter() {
    	  return counter;
      }
}

