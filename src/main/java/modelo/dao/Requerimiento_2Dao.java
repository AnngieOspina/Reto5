package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        Connection connection = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_2Vo> listado_registros_rq2 = new ArrayList<Requerimiento_2Vo>();
        String sql = "SELECT p.ID_Proyecto, mc.Nombre_Material, mc.Precio_Unidad FROM Proyecto p JOIN Compra c ON (p.ID_Proyecto=c.ID_Proyecto) JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion=mc.ID_MaterialConstruccion) WHERE p.ID_Proyecto In (23,38,50)ORDER BY p.ID_Proyecto ASC";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Requerimiento_2Vo requerimiento2 = new Requerimiento_2Vo();
                requerimiento2.setIdProyecto(rs.getInt("ID_Proyecto"));
                requerimiento2.setMaterial(rs.getString("Nombre_Material"));
                requerimiento2.setPrecioUnidad(rs.getInt("Precio_Unidad"));
                listado_registros_rq2.add(requerimiento2);
            }
        }
        return listado_registros_rq2;
    }
}