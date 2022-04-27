package br.com.aragy.singleton.JDBCTeste;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
class JDBCSingletonDemo{  
    static int count=1;  
    static int  choice;  
    public static void main(String[] args) throws IOException {  
          
        JDBCSingleton jdbc= JDBCSingleton.getInstance();  
          
          
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
   do{   
        System.out.println("DATABASE OPERATIONS");  
        System.out.println(" --------------------- ");  
        System.out.println(" 1. Inserir            ");  
        System.out.println(" 2. Visualizar      ");  
        System.out.println(" 3. Deletar   ");  
        System.out.println(" 4. Update    ");  
        System.out.println(" 5. Exit      ");  
          
        System.out.print("\n");  
        System.out.print("Escolha uma das tarefas a realizar no banco: ");  
          
        choice=Integer.parseInt(br.readLine());  
        switch(choice) {  
              
           case 1:{  
                    System.out.print("Entre com o username : ");  
                    String username=br.readLine();  
                    System.out.print("Entre com o password: ");  
                    String password=br.readLine();  
                      
                    try {  
                            int i= jdbc.insert(username, password);  
                            if (i>0) {  
                            System.out.println((count++) + " Dado inserido com sucesso");  
                            }else{  
                                System.out.println("Dado não foi inserido");      
                            }  
                          
                        } catch (Exception e) {  
                          System.out.println(e);  
                        }  
                      
                     System.out.println("Pressione Enter para continuar...");  
                     System.in.read();  
                       
                   }
                   break;  
            case 2:{  
                    System.out.print("Entre com o username : ");  
                    String username=br.readLine();  
               
                    try  {  
                            jdbc.view(username);  
                         } catch (Exception e) {  
                          System.out.println(e);  
                        }  
                     System.out.println("Pressione Enter para continuar...");  
                     System.in.read();  
                       
                   }
                  break;  
             case 3:{  
                     System.out.print("Entre com o userid que vc quer remover: ");  
                     int userid=Integer.parseInt(br.readLine());  
             
                     try {  
                            int i= jdbc.delete(userid);  
                            if (i>0) {  
                            System.out.println((count++) + " Dado removido com sucesso");  
                            }else{  
                                System.out.println("Dado não foi removido");      
                            }  
                          
                         } catch (Exception e) {  
                          System.out.println(e);  
                         }  
                     System.out.println("Pressione Enter para continuar...");  
                     System.in.read();  
                       
                    }
                   break;  
             case 4:{  
                    System.out.print("Entre com o username que vc quer atualizar ");  
                    String username=br.readLine();  
                    System.out.print("Entre com a senha");  
                    String password=br.readLine();  
                      
                    try {  
                            int i= jdbc.update(username, password);  
                            if (i>0) {  
                            System.out.println((count++) + " Dado atualizado com sucesso");  
                            }  
                          
                        } catch (Exception e) {  
                          System.out.println(e);  
                        }  
                     System.out.println("Pressione Enter para continuar...");  
                     System.in.read();  
                      
                   } 
                 break;  
                   
             default:  
                     return;  
        }  
          
       } while (choice!=4);   
   }  
}