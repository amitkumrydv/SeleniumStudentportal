# selenium-studentportal
Automate Student portal using selenium Junit and TestNG. 
1. Setup TestNG --> https://github.com/testng-team/testng-eclipse

pageObject Structure

![image](https://github.com/amitkumrydv/SeleniumStudentportal/assets/98074991/1f8674d3-0697-4c75-95cf-9ebe7a229fc7)
In this structure, the LoginPage and HomePage classes contain elements and methods related to specific pages, while the LoginPageMethods and HomePageMethods classes contain methods that perform actions on those pages. This separation can be useful when you have a large number of methods or when methods are reused across different pages.
 
 
 Chrome driver 
 
 The list of Chrome command-line arguments you've provided is used to configure various aspects of Chrome's behavior when running in an automated testing context. Let's briefly explain what each of these arguments does:

--disable-bundled-ppapi-flash: Disables the bundled Pepper Plugin API (PPAPI) Flash player.

--disable-plugins-discovery: Disables the discovery of plugins.

--disable-hang-monitor: Disables the hang monitor, which can detect if Chrome has stopped responding.

--disable-prompt-on-repost: Disables the prompt when navigating away from a page with unsaved form data.

--enable-experimental-accessibility: Enables experimental accessibility features.

--test-type: Deprecated argument, no longer necessary for recent versions of Chrome and ChromeDriver.

--disable-infobars: Disables the infobars that Chrome displays for notifications.

--disable-dev-shm-usage: Disables the use of /dev/shm for storing temporary files.

--no-sandbox: Disables the Chrome sandbox, which can be useful in some testing scenarios but is less secure.

--disable-browser-side-navigation: Disables browser-side navigation, which can help improve stability in automation.

--disable-gpu: Disables the GPU (Graphics Processing Unit), which can improve stability in headless mode or on systems without GPUs.

--disable-software-rasterizer: Disables the software rasterizer, which can help improve performance in headless mode.

--disable-default-apps: Disables the installation of default apps.

--disable-extensions: Disables all installed extensions.

--disable-popup-blocking: Disables the popup blocker.

--disable-translate: Disables the built-in translation feature.

--disable-web-security: Disables web security features, which can be useful for testing local files or bypassing CORS restrictions.

--ignore-certificate-errors: Ignores SSL certificate errors, which can be useful for testing on sites with invalid certificates.





// <suite name="StudentportalDashboard"  allow-return-values="true" verbose="10">

name="tests": This attribute specifies the name of the suite. You've named your suite "tests."

allow-return-values="true": This attribute, when set to "true," allows your test methods to return values. In TestNG, test methods can return values, and these values can be used in other parts of your test suite or for assertions.

verbose="10": This attribute sets the verbosity level of the suite. The verbose attribute accepts an integer value, and a higher value means more detailed output during test execution. In this case, a value of "10" indicates a high level of verbosity, providing detailed logging information.




