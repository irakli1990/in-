package com.plangenerator.ism.Controller;


import com.plangenerator.ism.JsonClasses.Item;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class XlsView extends AbstractXlsView {


    @Override
    public void buildExcelDocument(Map model, Workbook workbook, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        Logger logger = LoggerFactory.getLogger(XlsView.class);

        response.setHeader("Content-Disposition", "attachment; filename=\"plan.xls\"");
        List<String> side = Arrays.asList("Student", "nr albumu", "rok i poziom ISM", "rok akademicki", "semestr", "kierunek wiodący");
        List<String> tableHeader = Arrays.asList("Wydział", "Kierunek", "Moduł", "Kod USOS", "ECTS", "Wykład", "Ćwiczenia", "Grupa", "Prowadzący", "Warunki zaliczenia");
        List<String> tableFooter = Arrays.asList("Tutor", "Plan spotkań z tutorem", "Opiekun pracy diplomowej");


        String cellHeader = "INDYWIDUALNY SEMESTRALNY PROGRAM ZAJĘĆ";

        PropertyTemplate pt = new PropertyTemplate();
        @SuppressWarnings("unchecked")
        List<Item> list = (List<Item>) model.get("plans");
        System.out.println(list);

        Sheet sheet = workbook.createSheet("User List");

        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);


        Row headerRow = sheet.createRow(0);
        Cell cell = headerRow.createCell(2);
        cell.setCellValue(cellHeader);
        headerRow.createCell(9).setCellValue("Katowice, " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        cell.setCellStyle(cellStyle);


        for (int i = 0; i < side.size(); i++) {
            Row sideRow = sheet.createRow(i + 3);
            sideRow.createCell(0).setCellValue(side.get(i));
        }


        Cell sideCell = headerRow.createCell(1);
        cell.setCellValue(cellHeader);
        headerRow.createCell(9).setCellValue("Katowice, " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        cell.setCellStyle(cellStyle);

        Row header = sheet.createRow(10);
        for (int i = 0; i < tableHeader.size(); i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellStyle(cellStyle);
            headerCell.setCellValue(tableHeader.get(i));
        }


        int rowNum = 11;


        for (Item contact : list) {
            Row row = sheet.createRow(rowNum++);
            Row row1 = sheet.getRow(10);
            Iterator<Cell> cellIterator = row1.cellIterator();
            while (cellIterator.hasNext()) {
                Cell bodyCell = cellIterator.next();
                int columnIndex = bodyCell.getColumnIndex();
                sheet.autoSizeColumn(columnIndex);

            }
            row.createCell(0).setCellValue("");
            row.createCell(1).setCellValue(contact.getFacId());
            row.createCell(2).setCellValue(contact.getName().getPl());
            row.createCell(3).setCellValue(contact.getCourseId());
            row.createCell(4).setCellValue(contact.getEctsCreditsSimplified() != null ? Integer.parseInt(contact.getEctsCreditsSimplified().toString()) : 0);
            row.createCell(5).setCellValue("");
            row.createCell(6).setCellValue("");
            row.createCell(7).setCellValue("");
            row.createCell(8).setCellValue("");
            row.createCell(9).setCellValue("");
        }
        pt.drawBorders(new CellRangeAddress(10, 10 + list.size(), 0, 9),
                BorderStyle.THIN, BorderExtent.ALL);
        pt.drawBorders(new CellRangeAddress(3, 3 + side.size() - 1, 0, 1),
                BorderStyle.THIN, BorderExtent.ALL);

        pt.applyBorders(sheet);


        for (int i = 0; i < tableFooter.size(); i++) {
            Row sideRow = sheet.createRow((list.size() + 15) + i);
            sideRow.createCell(0).setCellValue(tableFooter.get(i));
        }

        Integer sum = list.stream()
                .map(x -> Integer.parseInt(x.getEctsCreditsSimplified() != null ? x.getEctsCreditsSimplified().toString() : "0"))
                .reduce(0, Integer::sum);


        Row total = sheet.createRow(11 + list.size());
        total.createCell(2).setCellValue("razem");
        total.createCell(4).setCellValue(Integer.parseInt(sum.toString()));
        total.createCell(5).setCellValue(0);
        total.createCell(6).setCellValue(0);


        Row signs = sheet.createRow(list.size() + 20);
        signs.createCell(0).setCellValue("Podpis Tutora");
        signs.createCell(6).setCellValue("Podpis Studenta");


        Row ismSigns = sheet.createRow(list.size() + 22);
        ismSigns.createCell(2).setCellValue("Podpis dyrektora Kolegium ISM");


    }


}

