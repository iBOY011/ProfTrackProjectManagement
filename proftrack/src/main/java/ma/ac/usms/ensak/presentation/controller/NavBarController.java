package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.presentation.Views.VBoxes.NavBarBox;

public class NavBarController {
    private static NavBarBox navbBarBox = new NavBarBox();

    public NavBarController() {

    }

    public static NavBarBox getNavBarBox() {
        return navbBarBox;
    }

}
