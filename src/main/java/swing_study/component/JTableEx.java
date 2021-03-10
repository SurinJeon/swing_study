package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import swing_study.component.table.Book;
import swing_study.component.table.BookCategory;
import swing_study.component.table.BookTablePanel;
import swing_study.component.table.DeptTablePanel;
import swing_study.component.table.EmpTablePanel;
import swing_study.component.table.MyTablePanel;
import swing_study.component.table.Student;
import swing_study.component.table.TitleTablePanel;
import swing_study.panel.Department;
import swing_study.panel.Employee;
import swing_study.panel.Title;

@SuppressWarnings("serial")
public class JTableEx extends JFrame {

	private JPanel contentPane;
	private JTable table1;

	private List<Student> stdList = new ArrayList<Student>();
	private List<Department> deptList = new ArrayList<Department>();
	private List<Title> titleList = new ArrayList<Title>();
	private List<Employee> empList = new ArrayList<Employee>();
	private List<BookCategory> bcList = new ArrayList<BookCategory>();
	private List<Book> bookList = new ArrayList<Book>();
	
	public JTableEx() {
		// pTable2의 pCustomTable2를 위한 data 삽입
		stdList.add(new Student(1, "짱수린", 50, 60, 60));
		stdList.add(new Student(2, "짱짱수린", 70, 71, 70));
		stdList.add(new Student(3, "전수린", 90, 92, 100));
		stdList.add(new Student(4, "짱전수린", 60, 63, 67));
		
		deptList.add(new Department(1, "개발", 8));
		deptList.add(new Department(2, "인사", 18));
		deptList.add(new Department(3, "총무", 28));
		
		titleList.add(new Title(1, "사장"));
		titleList.add(new Title(2, "부장"));
		titleList.add(new Title(3, "과장"));
		titleList.add(new Title(4, "대장"));
		titleList.add(new Title(5, "사원"));
		
		empList.add(
				new Employee(
						1, "짱수린",
						titleList.get(0),
						null,
						5000000,
						deptList.get(0)
						)
				);
		
		empList.add(
				new Employee(
						2, "이성래",
						titleList.get(1),
						new Employee(1, "짱수린"),
						1500000,
						deptList.get(1)
						)
				);
		empList.add(
				new Employee(
						3, "조민희",
						titleList.get(2),
						new Employee(1, "짱수린"),
						500000,
						deptList.get(2)
						)
				);
		
		bcList.add(new BookCategory(1, "수학"));
		bcList.add(new BookCategory(2, "전자"));
		bcList.add(new BookCategory(3, "컴퓨터"));
		bcList.add(new BookCategory(4, "통계"));

		bookList.add(new Book("40001", "The elements of statistical learning", 0, bcList.get(0), 1, 3));
		bookList.add(new Book("40002", "Computer vision : a modern approach", 1, bcList.get(2), 1, 5));
		bookList.add(new Book("40003", "MATLAB for engineers", 0, bcList.get(1), 1, 3));
		bookList.add(new Book("40004", "CUDA by example", 1, bcList.get(0), 1, 3));
		bookList.add(new Book("40005", "An introduction to 3D computer vision", 1, bcList.get(2), 1, 5));
		bookList.add(new Book("40006", "Numerical methods", 0, bcList.get(0), 1, 3));
		bookList.add(new Book("40007", "Image-based modeling", 0, bcList.get(2), 1, 5));
		bookList.add(new Book("40008", "Machine learning", 1, bcList.get(2), 1, 5));
		bookList.add(new Book("40009", "Probabilistic robotics", 1, bcList.get(3), 1, 5));
		bookList.add(new Book("40010", "Pattern recognition and machine learning", 0, bcList.get(2), 1, 5));
		
		
		initialize();
	} // end of constructor
	
	private void initialize() {
		setTitle("JTable Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel pTable1 = new JPanel();
		pTable1.setBorder(new TitledBorder(null, "Basic Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pTable1);
		pTable1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane1 = new JScrollPane();
		pTable1.add(scrollPane1, BorderLayout.CENTER);
		
		table1 = new JTable();
		table1.setModel(getModel()); // 원래 setModel의 argument로 들어간거를 다 빼서 method 추출함
		scrollPane1.setViewportView(table1);
		
		JPanel pTable2 = new JPanel();
		pTable2.setBorder(new TitledBorder(null, "Custom Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pTable2);
		pTable2.setLayout(new BorderLayout(0, 0));
		
		/////////////////////////////////////////////////// list 추가
		MyTablePanel pCustomTable2 = new MyTablePanel();
		pCustomTable2.setList(stdList);
		pTable2.add(pCustomTable2, BorderLayout.CENTER);
		
		JPanel pTable3 = new JPanel();
		contentPane.add(pTable3);
		pTable3.setLayout(new BorderLayout(0, 0));
		
		DeptTablePanel pDeptTable3 = new DeptTablePanel();
		// deptList를 던져주기
		pDeptTable3.setList(deptList);
		pTable3.add(pDeptTable3, BorderLayout.CENTER);
		
		JPanel pTable4 = new JPanel();
		contentPane.add(pTable4);
		pTable4.setLayout(new BorderLayout(0, 0));
		
		TitleTablePanel pTitlePanel4 = new TitleTablePanel();
		pTitlePanel4.setList(titleList);
		
		pTable4.add(pTitlePanel4, BorderLayout.CENTER);
		
		JPanel pTable5 = new JPanel();
		contentPane.add(pTable5);
		pTable5.setLayout(new BorderLayout(0, 0));
		
		EmpTablePanel pEmpTable5 = new EmpTablePanel();
		pEmpTable5.setList(empList);
		pTable5.add(pEmpTable5, BorderLayout.CENTER);
		
		JPanel pTable6 = new JPanel();
		contentPane.add(pTable6);
		pTable6.setLayout(new BorderLayout(0, 0));
		
		BookTablePanel pBookTable6 = new BookTablePanel();
		pBookTable6.setList(bookList);
		pTable6.add(pBookTable6, BorderLayout.CENTER);
	} // end of initialize()
	
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	} // end of getModel()
	
	class CustomTableModel extends DefaultTableModel{
		// table에 있는 data를 수정할 수 없도록 만들기 위한 class

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	} // end of CustomTableModel
	
	public Object[][] getData() {
		// data 구하는 부분 추출
		return new Object[][] {
			{1, "짱바둑", 20, "여자"},
			{2, "김고영", 11, "남자"},
		};
	} // end of getData()
	
	public String[] getColumnNames() {
		// 여기도 column 구하는거 따로 추출해서 method로 뽑아냄
		return new String[] {
			"학생번호", "학생명", "나이", "성별"
		};
	} // end of getColumnNames()

} // end of JFrame
