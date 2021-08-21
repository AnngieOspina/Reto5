package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_1Vo> listado_registros_rq1 = new ArrayList<Requerimiento_1Vo>();
        String sql = "SELECT l.ID_Lider, l.Salario, l.Ciudad_Residencia FROM Lider l WHERE l.Salario < (Select AVG(Salario) FROM Lider l ) ORDER BY Salario ASC ";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Requerimiento_1Vo requerimiento1 = new Requerimiento_1Vo();
                requerimiento1.setIdLider(rs.getInt("ID_Lider"));
                requerimiento1.setSalario(rs.getInt("Salario"));
                requerimiento1.setCiudad(rs.getString("Ciudad_Residencia"));
                listado_registros_rq1.add(requerimiento1);
            }
            rs.close();
            connection.close();
        }
        
        return listado_registros_rq1;
    }
    
}