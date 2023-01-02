//package cc.sven.hexwarriorproton.minefront.service.profiler;
//
//import cc.sven.hexwarriorproton.cherno.TimeUnit;
//
//public class XPSCounter {
//
//    private static long passedSecondsTrackerMillis = 0;
//    private static long ticksCounter = 0;
//    private static long frameCounter = 0;
//
//    public static void startProfiling() {
//        passedSecondsTrackerMillis = System.currentTimeMillis();
//    }
//
//    public static void countTick() {
//        ticksCounter++;
//    }
//
//    public static void resetTicks() {
//        ticksCounter = 0;
//    }
//
//    public static void countFrame() {
//        frameCounter++;
//    }
//
//    public static void resetFrames() {
//        frameCounter = 0;
//    }
//
//    public static boolean oneSecondPassed() {
//        final boolean isOneSecondPassed = System.currentTimeMillis() - passedSecondsTrackerMillis > TimeUnit.SECOND_IN_MILLIS;
//        if (isOneSecondPassed) {
//            passedSecondsTrackerMillis += TimeUnit.SECOND_IN_MILLIS;
//        }
//
//        return isOneSecondPassed;
//    }
//
//    public static String profileCountedPerSecond() {
//        final String profilePerSecond = "TPS:" + ticksCounter + " FPS:" + frameCounter;
//        resetTicks();
//        resetFrames();
//
//        return profilePerSecond;
//    }
//
//}
