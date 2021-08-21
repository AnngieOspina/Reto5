package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_3Vo> listado_registros_rq3 = new ArrayList<Requerimiento_3Vo>();
        String sql = "Select l.Clasificacion, AVG(Salario) as Promedio FROM Lider l GROUP BY l.Clasificacion HAVING AVG(Salario)>400000 ORDER BY Promedio DESC";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Requerimiento_3Vo requerimiento3 = new Requerimiento_3Vo();
                requerimiento3.setClasificacion(rs.getInt("Clasificacion"));
                requerimiento3.setPromedio(rs.getDouble("Promedio"));
                listado_registros_rq3.add(requerimiento3);
            }
        }
        return listado_registros_rq3;
    }
}