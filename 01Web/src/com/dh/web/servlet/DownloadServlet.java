package com.dh.web.servlet;
/**
 * 文件下载
 */
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "DownloadServlet",urlPatterns = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //拿到文件      在超链接后加入参数
        String filename = request.getParameter("filename");

        /**
         *正常网页上直接点击就会下载，也会自动解析，我们需要直接下载不解析
         */
        //设置文件类型给服务器看，服务器看的是MIME类型
        response.setContentType(this.getServletContext().getMimeType(filename));
        //设置头，告诉浏览器直接下载，不解析
        response.setHeader("Content-Disposition", "attachment;filename="+filename);

        //获得绝对路径
        String path=this.getServletContext().getRealPath("download/"+filename);
        //输入流
        InputStream is=new FileInputStream(path);
        //servlet输出流
        ServletOutputStream sos=response.getOutputStream();
        //文件拷贝模板
        byte[] b=new byte[1024];
        int len=0;
        while((len=is.read(b)) != -1){
            sos.write(b, 0, len);
        }
        is.close();
        //sos.close();  输出流可不关，服务器会控制，new的流要关
    }
}
