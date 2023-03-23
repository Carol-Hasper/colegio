package com.app.web.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.model.Alumno;
import com.app.web.repository.r.AlumnoRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service 
public class AlumnoService {
 @Autowired
	private AlumnoRepository alumnorepository;
	
	public List<Alumno>buscar(){
		return alumnorepository.findAll();
	}
	public Alumno insertar(Alumno alumno) {
		return alumnorepository.save(alumno);
	}
	public Alumno actualizar (Alumno alumno) {
		return alumnorepository.save(alumno);
	}
	public void eliminar(int id) {
		alumnorepository.deleteById(id);
	}
public byte[] generarPdf(HttpServletResponse response) throws IOException, DocumentException {
		
		List<Alumno> alumnos = alumnorepository.findAll();
		
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);
		
		document.open();	
        
        // Agregar título
        Paragraph titulo = new Paragraph("Lista de alumnos");
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titulo);
        
        // Agregar tabla con datos de los alumnos
        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(20f);
        tabla.setSpacingAfter(20f);
        
        PdfPCell celda1 = new PdfPCell(new Paragraph("ID"));
        PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre"));
        PdfPCell celda3 = new PdfPCell(new Paragraph("Apellido"));
        PdfPCell celda4 = new PdfPCell(new Paragraph("DNI"));
        PdfPCell celda5 = new PdfPCell(new Paragraph("Teléfono"));
        
        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda4);
        tabla.addCell(celda5);
        
        for (Alumno alumno : alumnos) {
            tabla.addCell(String.valueOf(alumno.getId()));
            tabla.addCell(alumno.getNombre());
            tabla.addCell(alumno.getApellido());
            tabla.addCell(alumno.getDni());
            tabla.addCell(alumno.getTelefono());
        }
        
        document.add(tabla);
        document.close();
        response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"alumnos.pdf\"");
		response.setContentLength(baos.size());

		ServletOutputStream outputStream = response.getOutputStream();
		baos.writeTo(outputStream);
		outputStream.flush();
		outputStream.close();

        return baos.toByteArray();
	}
		
}

