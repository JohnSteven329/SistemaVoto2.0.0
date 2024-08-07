package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import modelo.Curso;
import modelo.Estudiante;

public class PadronElectoralFrame extends JInternalFrame {
    private JTable tableCursosEstudiantes;
    private DefaultTableModel tableModel;
    private List<Curso> cursos;

    public PadronElectoralFrame(List<Curso> cursos) {
        super("Padrón Electoral", false, true, false, false);
        setRootPaneCheckingEnabled(false);
        setSize(600, 400);
        getContentPane().setLayout(new BorderLayout());

        this.cursos = cursos;

        tableModel = new DefaultTableModel(new Object[]{"Curso", "Estudiantes"}, 0);
        tableCursosEstudiantes = new JTable(tableModel);
        getContentPane().add(new JScrollPane(tableCursosEstudiantes), BorderLayout.CENTER);

        actualizarTabla();
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);

        for (Curso curso : cursos) {
            StringBuilder estudiantesStr = new StringBuilder();
            for (Estudiante estudiante : curso.getEstudiantes()) {
                estudiantesStr.append(estudiante.getNombre()).append(", ");
            }

            if (estudiantesStr.length() > 0) {
                estudiantesStr.setLength(estudiantesStr.length() - 2); 
            }

            tableModel.addRow(new Object[]{curso.getNombre(), estudiantesStr.toString()});
        }
    }
}
