package comp.demoSerializable;

import java.util.ArrayList;

/**
 * @author PachputeJayesh Serialization:- is a process of converting an object
 *         into a sequence of bytes which can be persisted to a disk or database
 *         or can be sent through streams.
 *
 *         The reverse process of creating object from sequence of bytes is
 *         called deserialization.
 * 
 *         A class must implement Serializable interface present in java.io
 *         package in order to serialize its object successfully.
 * 
 *         Serializable is a marker interface that adds serializable behaviour
 *         to the class implementing it.
 * 
 *         Java provides Serializable API encapsulated under java.io package for
 *         serializing and deserializing objects which include,
 *         java.io.serializable java.io.Externalizable ObjectInputStream
 *         ObjectOutputStream
 * 
 *Java Marker interface:- 
 *		   Marker Interface is a special interface in Java without any field and method. 
 *		   Marker interface is used to inform compiler that the class implementing it 
 *		   has some special behaviour or meaning. 
 *         Some example of Marker interface are,
 *         java.io.serializable 
 *         java.lang.Cloneable 
 *         java.rmi.Remote
 *         java.util.RandomAccess
 *         
 *         All these interfaces does not have any method and field. 
 *         They only add special behavior to the classes implementing them. 
 *         However marker interfaces have been deprecated since Java 5, 
 *         they were replaced by Annotations. 
 *         Annotations are used in place of Marker Interface that play the exact same role 
 *         as marker interfaces did before.
 *         
 *         To implement serialization and deserialization, 
 *         Java provides two classes ObjectOutputStream and ObjectInputStream.
 *         
 *ObjectOutputStream class:-
		   It is used to write object states to the file. 
		   An object that implements java.io.Serializable interface can be written to streams. 
		   It provides various methods to perform serialization.   
		   
ObjectInputStream class
		  An ObjectInputStream deserializes objects 
		  and primitive data written using an ObjectOutputStream.		   

public final void writeObject(object x) throws IOException
          The writeObject() method of ObjectOutputStream class serializes an object 
          and send it to the output stream.
          
public final Object readObject() throws IOException,ClassNotFoundException          
		  The readObject() method of ObjectInputStream class 
          references object out of stream and deserialize it. 
          
 *while serializing if you do not want any field to be part of object state 
 *then declare it either static or transient based on your need 
 *and it will not be included during java serialization process.
 *
 *       Static members are not not serialized as static members are class level
 *       not object level. 
 *       
 *        Transient stores default value instead of object value;
 */
public class SerializationDemoTest {

	public static void main(String[] args) {
		
		Employee e1= new Employee(67,"Shubham","Sr.Tester",90000,35);
		Employee e2= new Employee(45,"Nita","Sr.Developer",95000,30);
		Employee e3= new Employee(167,"Abhi","Manager",150000,45);
		
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		
		String fname="abc.txt";
		EmployeeOps obj = new EmployeeOps();
		
		obj.writeData(fname,emplist);
		obj.readData(fname);
	}

}
