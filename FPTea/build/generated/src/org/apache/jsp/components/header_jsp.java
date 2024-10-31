package org.apache.jsp.components;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- Required Meta Tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- Document Title, Description, and Author -->\n");
      out.write("        <title>Header</title>\n");
      out.write("        <meta name=\"description\" content=\"FPTEA COFFEE\">\n");
      out.write("        <meta name=\"author\" content=\"BootstrapBrain\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Css/styleUserShopping.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"512x512\" href=\"img/FPT.svg.png\">\n");
      out.write("        <!-- Google Fonts Files -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\"\n");
      out.write("              integrity=\"sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==\"\n");
      out.write("              crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("        <!-- Load jQuery -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <!-- Popper.js -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js\"></script>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Bootstrap JS -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\" integrity=\"sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("        <!-- CSS Files -->\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"Css/styleUserShopping.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Header -->\n");
      out.write("\n");
      out.write("        <header id=\"header\" class=\"bsb-tpl-bg-50 sticky-top bsb-spacer-top-3 bsb-spacer-top-md-5 bsb-spacer-top-xl-6 bsb-tpl-header-sticky bsb-tpl-header-sticky-animation\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-12\">\n");
      out.write("                        <!-- Navbar 1 - Bootstrap Brain Component -->\n");
      out.write("                        <nav class=\"navbar navbar-expand-lg bsb-navbar bsb-navbar-hover bsb-navbar-caret bsb-tpl-navbar-sticky bg-white border border-dark px-xl-3\" data-bsb-sticky-target=\"#header\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <a class=\"navbar-brand\" href=\"MainController?action=Back_Home\">\n");
      out.write("                                    <img src=\"img/FPT.svg.png\" class=\"bsb-tpl-logo\" alt=\"\">\n");
      out.write("                                </a>\n");
      out.write("                                <button class=\"navbar-toggler border-0\" type=\"button\" data-bs-toggle=\"offcanvas\" data-bs-target=\"#offcanvasNavbar\" aria-controls=\"offcanvasNavbar\">\n");
      out.write("                                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" fill=\"currentColor\" class=\"bi bi-list\" viewBox=\"0 0 16 16\">\n");
      out.write("                                    <path fill-rule=\"evenodd\" d=\"M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z\" />\n");
      out.write("                                    </svg>\n");
      out.write("                                </button>       \n");
      out.write("\n");
      out.write("                                <div class=\"offcanvas offcanvas-end\" tabindex=\"-1\" id=\"offcanvasNavbar\" aria-labelledby=\"offcanvasNavbarLabel\">\n");
      out.write("                                    <div class=\"offcanvas-header\">\n");
      out.write("                                        <h5 class=\"offcanvas-title\" id=\"offcanvasNavbarLabel\">Menu</h5>\n");
      out.write("                                        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"offcanvas\" aria-label=\"Close\"></button>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"offcanvas-body\">\n");
      out.write("                                        <ul class=\"navbar-nav justify-content-end flex-grow-1\" >\n");
      out.write("                                            <div class=\"navigation-card\">\n");
      out.write("                                                <form action=\"MainController\" method=\"POST\">\n");
      out.write("                                                    <li class=\"nav-item\">\n");
      out.write("                                                        <div class=\"input-wrapper\">\n");
      out.write("                                                            <button class=\"icon tab\" type=\"button\"> \n");
      out.write("                                                                <svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" fill=\"none\" viewBox=\"0 0 24 24\">\n");
      out.write("                                                                <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-width=\"2\" d=\"m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z\"/>\n");
      out.write("                                                                </svg>\n");
      out.write("                                                            </button>\n");
      out.write("                                                            <input placeholder=\"search..\" class=\"input\" name=\"searchProduct\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.searchProduct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                                            <input type=\"hidden\"name=\"action\" value=\"Search_Product\"/> \n");
      out.write("                                                        </div>\n");
      out.write("                                                    </li>\n");
      out.write("                                                </form>\n");
      out.write("                                                <li class=\"nav-item\">\n");
      out.write("                                                    <a href=\"MainController?action=Back_Home\" class=\"tab\">\n");
      out.write("                                                        <svg\n");
      out.write("                                                            class=\"svgIcon\"\n");
      out.write("                                                            viewBox=\"0 0 104 100\"\n");
      out.write("                                                            fill=\"none\"\n");
      out.write("                                                            xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                                            >\n");
      out.write("                                                        <path\n");
      out.write("                                                            d=\"M100.5 40.75V96.5H66V68.5V65H62.5H43H39.5V68.5V96.5H3.5V40.75L52 4.375L100.5 40.75Z\"\n");
      out.write("                                                            stroke=\"black\"\n");
      out.write("                                                            stroke-width=\"7\"\n");
      out.write("                                                            ></path>\n");
      out.write("                                                        </svg>\n");
      out.write("                                                    </a>\n");
      out.write("                                                </li>                                         \n");
      out.write("                                                <li class=\"nav-item\">\n");
      out.write("                                                    <a href=\"MainController?action=View\" class=\"tab\">\n");
      out.write("                                                        <?xml version=\"1.0\" encoding=\"utf-8\"?><svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" viewBox=\"0 0 122.9 107.5\" style=\"enable-background:new 0 0 122.9 107.5\" xml:space=\"preserve\"><g><path d=\"M3.9,7.9C1.8,7.9,0,6.1,0,3.9C0,1.8,1.8,0,3.9,0h10.2c0.1,0,0.3,0,0.4,0c3.6,0.1,6.8,0.8,9.5,2.5c3,1.9,5.2,4.8,6.4,9.1 c0,0.1,0,0.2,0.1,0.3l1,4H119c2.2,0,3.9,1.8,3.9,3.9c0,0.4-0.1,0.8-0.2,1.2l-10.2,41.1c-0.4,1.8-2,3-3.8,3v0H44.7 c1.4,5.2,2.8,8,4.7,9.3c2.3,1.5,6.3,1.6,13,1.5h0.1v0h45.2c2.2,0,3.9,1.8,3.9,3.9c0,2.2-1.8,3.9-3.9,3.9H62.5v0 c-8.3,0.1-13.4-0.1-17.5-2.8c-4.2-2.8-6.4-7.6-8.6-16.3l0,0L23,13.9c0-0.1,0-0.1-0.1-0.2c-0.6-2.2-1.6-3.7-3-4.5 c-1.4-0.9-3.3-1.3-5.5-1.3c-0.1,0-0.2,0-0.3,0H3.9L3.9,7.9z M96,88.3c5.3,0,9.6,4.3,9.6,9.6c0,5.3-4.3,9.6-9.6,9.6 c-5.3,0-9.6-4.3-9.6-9.6C86.4,92.6,90.7,88.3,96,88.3L96,88.3z M53.9,88.3c5.3,0,9.6,4.3,9.6,9.6c0,5.3-4.3,9.6-9.6,9.6 c-5.3,0-9.6-4.3-9.6-9.6C44.3,92.6,48.6,88.3,53.9,88.3L53.9,88.3z M33.7,23.7l8.9,33.5h63.1l8.3-33.5H33.7L33.7,23.7z\"/></g></svg>\n");
      out.write("                                                    </a>\n");
      out.write("                                                </li>\n");
      out.write("                                                <li class=\"nav-item dropdown\">\n");
      out.write("                                                    <a href=\"#\" class=\"tab\" class=\"nav-link dropdown-toggle\" href=\"#!\" id=\"blogDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                                        <svg\n");
      out.write("                                                            width=\"104\"\n");
      out.write("                                                            height=\"100\"\n");
      out.write("                                                            viewBox=\"0 0 104 100\"\n");
      out.write("                                                            fill=\"none\"\n");
      out.write("                                                            xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                                            >\n");
      out.write("                                                        <rect\n");
      out.write("                                                            x=\"21.5\"\n");
      out.write("                                                            y=\"3.5\"\n");
      out.write("                                                            width=\"60\"\n");
      out.write("                                                            height=\"60\"\n");
      out.write("                                                            rx=\"30\"\n");
      out.write("                                                            stroke=\"black\"\n");
      out.write("                                                            stroke-width=\"7\"\n");
      out.write("                                                            ></rect>\n");
      out.write("                                                        <g clip-path=\"url(#clip0_41_27)\">\n");
      out.write("                                                        <mask\n");
      out.write("                                                            id=\"mask0_41_27\"\n");
      out.write("                                                            style=\"mask-type:luminance\"\n");
      out.write("                                                            maskUnits=\"userSpaceOnUse\"\n");
      out.write("                                                            x=\"0\"\n");
      out.write("                                                            y=\"61\"\n");
      out.write("                                                            width=\"104\"\n");
      out.write("                                                            height=\"52\"\n");
      out.write("                                                            >\n");
      out.write("                                                            <path\n");
      out.write("                                                                d=\"M0 113C0 84.2812 23.4071 61 52.1259 61C80.706 61 104 84.4199 104 113H0Z\"\n");
      out.write("                                                                fill=\"white\"\n");
      out.write("                                                                ></path>\n");
      out.write("                                                        </mask>\n");
      out.write("                                                        <g mask=\"url(#mask0_41_27)\">\n");
      out.write("                                                        <path\n");
      out.write("                                                            d=\"M-7 113C-7 80.4152 19.4152 54 52 54H52.2512C84.6973 54 111 80.3027 111 112.749H97C97 88.0347 76.9653 68 52.2512 68H52C27.1472 68 7 88.1472 7 113H-7ZM-7 113C-7 80.4152 19.4152 54 52 54V68C27.1472 68 7 88.1472 7 113H-7ZM52.2512 54C84.6973 54 111 80.3027 111 112.749V113H97V112.749C97 88.0347 76.9653 68 52.2512 68V54Z\"\n");
      out.write("                                                            fill=\"black\"\n");
      out.write("                                                            ></path>\n");
      out.write("                                                        </g>\n");
      out.write("                                                        </g>\n");
      out.write("                                                        <defs>\n");
      out.write("                                                        <clipPath id=\"clip0_41_27\">\n");
      out.write("                                                            <rect\n");
      out.write("                                                                width=\"104\"\n");
      out.write("                                                                height=\"39\"\n");
      out.write("                                                                fill=\"white\"\n");
      out.write("                                                                transform=\"translate(0 61)\"\n");
      out.write("                                                                ></rect>\n");
      out.write("                                                        </clipPath>\n");
      out.write("                                                        </defs>\n");
      out.write("                                                        </svg>\n");
      out.write("                                                    </a>\n");
      out.write("                                                    <ul class=\"dropdown-menu border-0 shadow bsb-zoomIn\" aria-labelledby=\"blogDropdown\">\n");
      out.write("                                                        <li><a class=\"dropdown-item\" href=\"MainController?action=Profile_Page\"><svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" fill=\"currentColor\" viewBox=\"0 0 24 24\">\n");
      out.write("                                                                <path fill-rule=\"evenodd\" d=\"M12 20a7.966 7.966 0 0 1-5.002-1.756l.002.001v-.683c0-1.794 1.492-3.25 3.333-3.25h3.334c1.84 0 3.333 1.456 3.333 3.25v.683A7.966 7.966 0 0 1 12 20ZM2 12C2 6.477 6.477 2 12 2s10 4.477 10 10c0 5.5-4.44 9.963-9.932 10h-.138C6.438 21.962 2 17.5 2 12Zm10-5c-1.84 0-3.333 1.455-3.333 3.25S10.159 13.5 12 13.5c1.84 0 3.333-1.455 3.333-3.25S13.841 7 12 7Z\" clip-rule=\"evenodd\"/>\n");
      out.write("                                                                </svg>\n");
      out.write("                                                                Profile\n");
      out.write("                                                            </a></li>\n");
      out.write("                                                        <li><a class=\"dropdown-item\" href=\"MainController?action=Logout\"><svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" fill=\"none\" viewBox=\"0 0 24 24\">\n");
      out.write("                                                                <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M20 12H8m12 0-4 4m4-4-4-4M9 4H7a3 3 0 0 0-3 3v10a3 3 0 0 0 3 3h2\"/>\n");
      out.write("                                                                </svg>\n");
      out.write("                                                                Logout</a></li>\n");
      out.write("                                                    </ul>\n");
      out.write("                                                </li> \n");
      out.write("                                            </div>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <script src=\"Javascript/userShopping.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
