package com.guying.common.util.pdf;

import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author QJYou
 * @since 2023-07-01 19:48
 */
public class PdfBoxWatermark {
    /**
     * 给PDF添加纯文本水印
     */
    @SneakyThrows(IOException.class)
    public static void pdfTextWatermark(final String filePath, String text, String savePath) {
        // 读取原始 PDF 文件
        PDDocument document = PDDocument.load(new File(filePath));
        // 遍历 PDF 中的所有页面
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            PDPage page = document.getPage(i);
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
            // 设置字体和字号
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 36);
            // 设置透明度
            contentStream.setNonStrokingColor(new Color(11, 200, 32));
            // 添加文本水印
            contentStream.beginText();
            // 设置水印位置
            contentStream.newLineAtOffset(100, 100);
            // 设置水印内容
            contentStream.showText(text);
            contentStream.endText();
            contentStream.close();
        }
        // 保存修改后的 PDF 文件
        document.save(new File(savePath));
        document.close();
    }

    /**
     * 添加图片水印
     * Java使用pdfbox实现给pdf文件加图片水印——https://www.jb51.net/article/267446.htm
     *
     * @param filePath 文件路径
     * @param imgPath  图片路径
     */
    @SneakyThrows(IOException.class)
    public static void addImgWatermark(String filePath, String imgPath) {
        String name = filePath.substring(filePath.lastIndexOf(File.separator), filePath.lastIndexOf(".pdf"));
        String folder = filePath.substring(0, filePath.lastIndexOf(File.separator));
        File file = new File(filePath);
        try (PDDocument doc = PDDocument.load(file)) {
            PDImageXObject pdImage = PDImageXObject.createFromFile(imgPath, doc);

            WatermarkOptions options = new WatermarkOptions().size(120, 60)
                                                             .padding(20)
                                                             .layout(4, 3)
                                                             // 建议0-90度
                                                             .rotate(30);

            for (PDPage page : doc.getPages()) {
                addImgWatermark(doc, page, pdImage, options);
            }
            doc.save(folder + File.separator + name + "_WaterMark.pdf");
        }
    }

    @SneakyThrows(IOException.class)
    private static void addImgWatermark(PDDocument doc, PDPage page, PDImageXObject pdImage, WatermarkOptions options) {
        try (
                PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true)
        ) {
            float width = page.getMediaBox().getWidth();
            float height = page.getMediaBox().getHeight();
//            System.out.println("width=" + width + ",height=" + height);

            //有一些pdf页面是有角度翻转的，修正一下
            int rotation = page.getRotation();
//            System.out.println("page.getRotation()=" + rotation);
            switch (rotation) {
                case 90:
                    width = page.getMediaBox().getHeight();
                    height = page.getMediaBox().getWidth();
                    cs.transform(Matrix.getRotateInstance(Math.toRadians(90), height, 0));
                    break;
                case 180:
                    cs.transform(Matrix.getRotateInstance(Math.toRadians(180), width, height));
                    break;
                case 270:
                    width = page.getMediaBox().getHeight();
                    height = page.getMediaBox().getWidth();
                    cs.transform(Matrix.getRotateInstance(Math.toRadians(270), 0, width));
                    break;
                default:
                    break;
            }

            PDExtendedGraphicsState gs = new PDExtendedGraphicsState();
            gs.setNonStrokingAlphaConstant(0.2f);// 设置透明度
            gs.setAlphaSourceFlag(true);
            gs.setBlendMode(BlendMode.NORMAL);
            cs.setGraphicsStateParameters(gs);

            int row = options.row;
            int column = options.column;
            float imgWidth = options.width;
            float imgHeight = options.height;
            float padding = options.padding;
            int degree = options.degree;

            // 计算获得每个单元格的宽高
            float cellWidth = (width - padding * 2) / column;
            float cellHeight = (height - padding * 2) / row;
//            System.out.println("cellWidth=" + cellWidth + ",cellHeight=" + cellHeight);

            // 偏移量，如果单元格宽高大于图片宽高，这可以使图片居中
            float xOffset = padding + (cellWidth - imgWidth) / 2;
            float yOffset = padding + (cellHeight - imgHeight) / 2;

            float x;
            float y;
            for (int i = 0; i < row; i++) {
                y = i * cellHeight + yOffset;

                for (int j = 0; j < column; j++) {
                    x = j * cellWidth + xOffset;

                    // 旋转导致的x位置修正
                    x += Math.sin(Math.toRadians(degree)) * imgHeight;

//                    System.out.println((int) x + "," + (int) y);

                    Matrix matrix = new Matrix();
                    // 先移位
                    matrix.translate(x, y);
                    // 旋转
                    matrix.rotate(Math.toRadians(degree));
                    // 修改尺寸（必须在旋转后面，否则会变形）
                    matrix.scale(imgWidth, imgHeight);

                    // 画图
                    cs.drawImage(pdImage, matrix);
                }
            }

        }

    }

    static class WatermarkOptions {
        /**
         * 边距
         */
        float padding = 20;
        /**
         * 图片宽度
         */
        float width;
        /**
         * 图片高度
         */
        float height;
        /**
         * 旋转角度
         */
        int degree = 0;
        /**
         * 行数
         */
        int row = 1;
        /**
         * 列数
         */
        int column = 1;

        public WatermarkOptions() {

        }

        public WatermarkOptions padding(int p) {
            if (p < 10) {
                throw new IllegalArgumentException("边距不能小于0");
            }
            this.padding = p;
            return this;
        }

        public WatermarkOptions layout(int row, int column) {
            if (row <= 0 || column <= 0) {
                throw new IllegalArgumentException("行数或列数必须大于0");
            }
            this.row = row;
            this.column = column;

            return this;
        }

        public WatermarkOptions size(float width, float height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public WatermarkOptions rotate(int degree) {
            this.degree = degree;
            return this;
        }

    }

    public static void main(String[] args) {
        String filePath = "G:\\workspace\\IDEAWorkspace\\guying-common\\common-util\\src\\main\\resources\\com\\guying\\common\\util\\original.pdf";
        String savePath = "G:\\workspace\\IDEAWorkspace\\guying-common\\common-util\\src\\main\\resources\\com\\guying\\common\\util\\output.pdf";
        String text = "GUYING " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        pdfTextWatermark(filePath, text, savePath);

        String imgPath = "G:\\workspace\\IDEAWorkspace\\guying-common\\common-util\\src\\main\\resources\\com\\guying\\common\\util\\imgWatermark.png";
        addImgWatermark(filePath, imgPath);
    }
}
