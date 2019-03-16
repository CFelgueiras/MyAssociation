/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.model;

/**
 *
 * @author Cláudio Felgueiras
 */
public class Application {

    private String currentUser;

    public Application() {
    }

    public void setCurrentUser(String username) {
        this.currentUser = username;
    }

    public String getCurrentUser() {
        return this.currentUser;
    }
}
