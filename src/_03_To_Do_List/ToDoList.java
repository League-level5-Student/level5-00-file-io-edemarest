package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	String name;
	ArrayList<String> list = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Tasks");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");
	
	void run() {
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
		
		BufferedReader br;
		if(name != null) {
		try {
			br = new BufferedReader(new FileReader("src/_03_To_Do_List/"+name+".txt"));
			String lines = "";
			String line = "";
			while(line != null){
				line = br.readLine();
				lines = lines + "\n"+line;
			}
			JOptionPane.showMessageDialog(null, lines);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			String task = JOptionPane.showInputDialog("Enter a task to add to the list: ");
			list.add(task);
		}
		if(e.getSource() == view) {
			String allTasks = "";
			for(int i = 0; i < list.size(); i++) {
				if(i!=list.size()-1) {
				allTasks = allTasks + list.get(i)+"\n";
				}
				else {
					allTasks = allTasks + list.get(i);
				}
			}
			JOptionPane.showMessageDialog(null, "All your tasks: \n"+allTasks);
		}
		if(e.getSource() == remove) {
			String r = JOptionPane.showInputDialog("Enter a task you would like to remove from your list: ");
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).contains(r)) {
					list.remove(i);
				}
			}
		}
		if(e.getSource() == save) {
			name = JOptionPane.showInputDialog("Enter a name for the list: ");
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/"+name+".txt");
				for(int i = 0; i < list.size(); i++) {
				fw.write("#"+(i+1)+"    "+list.get(i)+"\n");	
				}
				fw.close();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}	
	
		if(e.getSource()==load) {
			
			String loc = JOptionPane.showInputDialog("Enter the location of the file you want to load: ");
			BufferedReader br;
			if(loc != null) {
			try {
				br = new BufferedReader(new FileReader("src/_03_To_Do_List/"+loc+".txt"));
				String lines = "";
				String line = "";
				while(line != null){
					line = br.readLine();
					list.add(line);
				}
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		}
		
}
			
		
			
	
}
