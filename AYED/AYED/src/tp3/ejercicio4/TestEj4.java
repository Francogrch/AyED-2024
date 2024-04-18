package tp3.ejercicio4;

import tp3.ejercicio3.GeneralTree;

import java.util.ArrayList;

public class TestEj4 {

    public static void main(String[] args) {
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(16));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(13));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(25));
        GeneralTree<AreaEmpresa> a4 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(10));
        GeneralTree<AreaEmpresa> a5 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(4));
        GeneralTree<AreaEmpresa> a6 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(7));
        GeneralTree<AreaEmpresa> a7 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(5));
        GeneralTree<AreaEmpresa> a8 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(6));
        GeneralTree<AreaEmpresa> a9 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(10));
        GeneralTree<AreaEmpresa> a10 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(18));
        GeneralTree<AreaEmpresa> a11 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(9));
        GeneralTree<AreaEmpresa> a12 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(12));
        GeneralTree<AreaEmpresa> a13 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(19));

        a1.addChild(a2);
        a2.addChild(a5);
        a2.addChild(a6);
        a2.addChild(a7);
        a1.addChild(a3);
        a3.addChild(a8);
        a3.addChild(a9);
        a3.addChild(a10);
        a1.addChild(a4);
        a4.addChild(a11);
        a4.addChild(a12);
        a4.addChild(a13);


        System.out.println("El promedio del arbol es de " + AnalizadorArbol.devolverMaximoPromedio(a1));

    }
}
