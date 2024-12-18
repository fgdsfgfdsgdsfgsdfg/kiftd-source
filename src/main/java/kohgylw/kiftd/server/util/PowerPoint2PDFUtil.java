package kohgylw.kiftd.server.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
//
//import org.apache.poi.hslf.model.Slide;
//import org.apache.poi.hslf.model.TextRun;
//import org.apache.poi.hslf.usermodel.RichTextRun;
//import org.apache.poi.hslf.usermodel.SlideShow;
import cn.hutool.core.io.IoUtil;
import kohgylw.kiftd.convert.server.bean.ConvertInfo;
import kohgylw.kiftd.convert.server.service.ConvertHandlerContext;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * <h2>PPT转PDF工具</h2>
 * <p>
 * 该工具是实现PPT在线预览功能的核心，能将ppt/pptx格式的文档以流形式转化为PDF。如果该文档中存在系统未安装的字体，则使用开源免费字体“文泉驿正黑”替代显示，以确保在非Windows系统下也能正确转换。该工具应由Spring
 * IOC容器管理。
 * </p>
 *
 * @author 青阳龙野(kohgylw)
 * @version 1.0
 */
@Component
public class PowerPoint2PDFUtil {

    /**
     * <h2>执行PPT格式转换（ppt/pptx）</h2>
     * <p>将输入流中的PPT文件转换为PDF格式并输出至指定输出流，该方法线程阻塞。</p>
     *
     * @param file 文件流 文件流
     * @param out  java.io.OutputStream 输出流，输出PDF格式
     * @author 青阳龙野(kohgylw)
     */
    public void convertPdf(File file, OutputStream out) throws Exception {
        ConvertInfo convertInfo = (new ConvertInfo(null, "pdf", file)).setFileName(file.getName()).setFixed(true);
        InputStream in = (new ConvertHandlerContext()).convert(convertInfo);
        IoUtil.copy(in, out);
        IoUtil.close(in);
        IoUtil.close(out);
    }

}
