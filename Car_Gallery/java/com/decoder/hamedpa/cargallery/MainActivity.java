package com.decoder.hamedpa.cargallery;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    CarGallery hamed;
    LinkList l=new LinkList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText n1 = (EditText) findViewById(R.id.editText1);
        final EditText n2 = (EditText) findViewById(R.id.editText2);
        final EditText md = (EditText) findViewById(R.id.editText);
        final EditText yr = (EditText) findViewById(R.id.editText3);

        final TextView an = (TextView) findViewById(R.id.answer);

        Button brand = (Button) findViewById(R.id.b);
        Button queue = (Button) findViewById(R.id.q);
        Button stack = (Button) findViewById(R.id.s);

        brand.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {


                l.add(new Car(n1.getText().toString(),md.getText().toString(),yr.getText().toString(),"B",Integer.parseInt(n2.getText().toString())));
                an.setText(l.toString());
            }


        });
        queue.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                l.Queue();
                an.setText(l.toString());
                //remove Queue
            }
        });

        stack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                l.removeLast();
                an.setText(l.toString());
            }
        });


    }



}
class Node{
    Object o;
    Node next;
    Node(){}
    Node(Object o){
        this.o=o;
    }
}
class CarGallery extends LinkList{
    //LinkList l=new LinkList();
    CarGallery(){
        first=null;
    }
}
class LinkList{
    Node first;
    LinkList(){
        first=null;
    }
    public void add(Object o){
        Node n=new Node(o);
        Node temp=first;
        if(first!=null){
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
        }
        else
            first=n;
    }
    void Queue() {
        Node temp = first;
        if (first != null) {
            first = first.next;
        } else {
            System.out.println("No Item");
        }
    }
    public void addAfter(Object a,Object af){
        Node temp=first;
        Node c;
        Node n=new Node(a);
        while(temp.o!=af){
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
    }
    public void addBefore(Object b,Object bf){
        Node temp=first;
        Node n=new Node(b);
        while((temp.next).o!=bf){
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
    }
    public void addFirst(Object o){
        Node temp=first;
        Node n=new Node(o);
        if(first!=null){
            n.next=first;
            first=n;
        }
        else
            first=n;
    }
    public void remove(Object o1){
        Node temp=first;
        if(first.o==o1){
            first=first.next;
            return;
        }
        while((temp.next).o!=o1){
            temp=temp.next;
            if(temp.next==null){
                System.out.println("This is not exist");
                return;
            }
        }
        temp.next=temp.next.next;

    }
    public void removeFirst(){
        Node temp=first;
        if(first!=null){
            first=first.next;
        }
        else
            first=null;
    }
    public void removeLast(){
        Node temp=first;
        if(first!=null){
            while((temp.next).next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
        else
            first=null;
    }
    public void removeWithNum(int num){
        Node temp=first;
        int s=num-1,i=0;
        if(first!=null){
            while(temp!=null){
                if(s==i)
                    break;
                temp=temp.next;
                i++;
            }
            temp.next=temp.next.next;
        }
    }
    @Override
    public String toString(){
        String str="";
        Node temp=first;

        while(temp!=null){
            str+=temp.o.toString()+"\n";
            temp=temp.next;
        }
        return str;


    }
}
class Car{
    String brand;
    String model;
    String year;
    String fuel;
    int distCovered;
    Car(String brand,String model,String year,String fuel,int distCovered){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.fuel=fuel;
        this.distCovered=distCovered;
    }
    @Override
    public boolean equals(Object o){
        Car c=(Car)o;
        if(c.brand.equals(brand)&&
                c.model.equals(model)&&
                c.year.equals(year)&&
                c.fuel.equals(fuel)&&
                c.distCovered==distCovered)
            return true;
        else
            return false;

    }
    @Override
    public String toString(){

        return brand+"\t"+model+"\t"+year+"\t"+fuel+"\t"+String.valueOf(distCovered);

    }
}

