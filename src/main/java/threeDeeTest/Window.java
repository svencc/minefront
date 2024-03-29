//package threeDeeTest;
//
//
//import org.lwjgl.glfw.GLFWErrorCallback;
//import org.lwjgl.opengl.GL;
//
//import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
//import static org.lwjgl.glfw.GLFW.*;
//import static org.lwjgl.opengl.GL11.*;
//import static org.lwjgl.system.MemoryUtil.NULL;
//
//public class Window {
//    private static Window window;
//    private int width, height;
//    private String title;
//    private long glfwWindow;
//
//
//    private Window() {
//        width = 1920;
//        height = 1080;
//        title = "ThreeDee";
//    }
//
//    public static Window get() {
//        if (Window.window == null) {
//            Window.window = new Window();
//        }
//
//        return Window.window;
//    }
//
//    public void run() {
//        System.out.println("Hello LWJGL " + org.lwjgl.Version.getVersion() + "!");
//        init();
//        loop();
//
//        // Free the memory
//        glfwFreeCallbacks(glfwWindow);
//        glfwDestroyWindow(glfwWindow);
//
//        // Terminate GLFW and free the error callback
//        glfwTerminate();
//        glfwSetErrorCallback(null).free();
//    }
//
//    public void init() {
//        // Setup an error callback
//        GLFWErrorCallback.createPrint(System.err).set();
//
//        // Initialize GLFW
//        if (!glfwInit()) {
//            throw new IllegalStateException("Unable to initialize GLFW.");
//        }
//
//        // Configure GLFW
//        glfwDefaultWindowHints();
//        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
//        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
//        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
//
//        // Create the window
//        glfwWindow = glfwCreateWindow(width, height, title, NULL, NULL);
//
//        if (glfwWindow == NULL) {
//            throw new IllegalStateException("Failed to create the GLFW window.");
//        }
//
//        // Make the OpenGL context current
//        glfwMakeContextCurrent(glfwWindow);
//        // Enable V-Sync
//        glfwSwapInterval(1);
//
//        // MAke the window visible
//        glfwShowWindow(glfwWindow);
//
//        // This line is critical for LWJGL's interoperation with GLFW's
//        // OpenGL context, or any context that is managed externally.
//        // LWJGL detects the context that is current in the current thread,
//        // creates the GLCapabilities instance and makes the OpenGL
//        // bindings available for use.
//        GL.createCapabilities();
//    }
//
//    private void loop() {
//        while (!glfwWindowShouldClose(glfwWindow)) {
//            // Poll events
//            glfwPollEvents();
//
//            glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
//            glClear(GL_COLOR_BUFFER_BIT);
//
//            glfwSwapBuffers(glfwWindow);
//        }
//    }
//
//}
