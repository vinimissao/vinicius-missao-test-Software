package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SupabaseJDBC {
    public static void main(String[] args) {


        String url = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:6543/postgres?sslmode=require";
        String user = "postgres.tphucrfirjqskflwnxss";
        String password = "Senac1234@"; // sua senha do Supabase

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Conectado ao Supabase PostgreSQL via Connection Pooler!");
            // Aqui você pode executar suas queries SQL
        } catch (SQLException e) {
            System.out.println("❌ Erro na conexão:");
            e.printStackTrace();
        }
    }
}
