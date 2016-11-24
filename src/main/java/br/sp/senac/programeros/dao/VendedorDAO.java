package br.sp.senac.programeros.dao;

/**
 *
 * @author Michael Facul
 */
import br.sp.senac.programeros.connection.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sp.senac.programeros.model.Vendedor;
import java.sql.Date;

public class VendedorDAO implements br.sp.senac.programeros.interfaces.VendedorInterface {
    Connection conexao;

    public VendedorDAO(Connection conexao) {
        this.conexao = conexao;
    }
    @Override
    public void inserir(Vendedor vendedor) {
        String sql = "insert into vendedores "
                + "(nome, endereco, bairro, cidade, estado, cep, telefone, celular, cadastro, ativo, deletado) VALUES"              
                + "(?,?,?,?,?,?,?,?,?,?,'')";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, vendedor.getNome());
            p.setString(2, vendedor.getEndereco());
            p.setString(3, vendedor.getBairro());
            p.setString(4, vendedor.getCidade());
            p.setString(5, vendedor.getEstado());
            p.setString(6, vendedor.getCep());
            p.setString(7, vendedor.getTelefone());
            p.setString(8, vendedor.getCelular());
            p.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            p.setString(10, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void alterar(Vendedor vendedor) {

        try {
            String sql = "UPDATE vendedores"
                    + " SET nome = ?, endereco = ?, bairro = ?, cidade = ?, "
                    + " estado = ?, cep = ?, telefone = ?, celular = ?,"
                    + " ativo = ?"
                    + " WHERE codigo = ?";

            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, vendedor.getNome());
            p.setString(2, vendedor.getEndereco());
            p.setString(3, vendedor.getBairro());
            p.setString(4, vendedor.getCidade());
            p.setString(5, vendedor.getEstado());
            p.setString(6, vendedor.getCep());
            p.setString(7, vendedor.getTelefone());
            p.setString(8, vendedor.getCelular());
            p.setString(9, String.valueOf(vendedor.getAtivo()));
            p.setInt(10, vendedor.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Vendedor> listarVendedores() {
        List<Vendedor> vendedores = new ArrayList<Vendedor>();

        try {
            String sql = "SELECT * FROM vendedores WHERE deletado <> '*'";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();

                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                Date cadastro = rs.getDate("cadastro");
                String ativo = rs.getString("ativo");
                

                vendedor.setCodigo(codigo);
                vendedor.setNome(nome);
                vendedor.setEndereco(endereco);
                vendedor.setBairro(bairro);
                vendedor.setCidade(cidade);
                vendedor.setEstado(estado);
                vendedor.setCep(cep);
                vendedor.setTelefone(telefone);
                vendedor.setCelular(celular);
                vendedor.setCadastro(cadastro);
                vendedor.setAtivo(ativo);
                

                vendedores.add(vendedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    @Override
    public Vendedor selecionar(int codigo) {

        Vendedor vendedor = new Vendedor();
        ConexaoBD conn = new ConexaoBD();

        String sql = "SELECT * FROM vendedores WHERE deletado <> '*' AND codigo= "+codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            vendedor.setCodigo(codigo);
            vendedor.setNome(rs.getString("nome"));
            vendedor.setEndereco(rs.getString("endereco"));
            vendedor.setBairro(rs.getString("bairro"));
            vendedor.setCidade(rs.getString("cidade"));
            vendedor.setEstado(rs.getString("estado"));
            vendedor.setCep(rs.getString("cep"));
            vendedor.setTelefone(rs.getString("telefone"));
            vendedor.setCelular(rs.getString("celular"));
            vendedor.setCadastro(rs.getDate("cadastro"));
            vendedor.setAtivo(rs.getString("ativo"));            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendedor;

    }

    @Override
    public Vendedor Remove(int codigo) {

        String sql = "DELETE FROM vendedores WHERE codigo =?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, codigo);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
//    public String verificar(String nome, String endereco, String bairro,
//            String cidade, String estado, String cep, String telefone, 
//            String celular, String cadastro, String ativo){
//        ConexaoBD conn = new ConexaoBD();
//        String name = null;
//        String adress = null;
//        String  = null;
//       
//        String sql = "SELECT * FROM usuarios WHERE deletado <> '*' AND ativo = 1 AND login= '"+nome+"'";
//        
//        try{
//            java.sql.Statement stmt = conexao.createStatement();
//            ResultSet rs = stmt.executeQuery(sql); 
//
//            while(rs.next()){
//                user = rs.getString("login");
//                pass = rs.getString("senha");
//
//                if(login.equals(user) && senha.equals(pass)){
//                    ret = rs.getString("nome");
//                }
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        
//        return ret;
//    } 
}
