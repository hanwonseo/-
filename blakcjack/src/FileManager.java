import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileManager {
	static boolean access = false;

	public static void makeFile() {
		try {
			String id, pw, name;

			File f = new File("data.txt");
			if (!f.exists())
				f.createNewFile();

			FileWriter fwr = new FileWriter(f, true);
			PrintWriter pwr = new PrintWriter(fwr);
			System.out.print("이름 :");
			name = GameManager.sc.next();
			System.out.print("아이디 :");
			id = GameManager.sc.next();
			System.out.print("암호 :");
			pw = GameManager.sc.next();
			GameManager.sc.nextLine();
			System.out.println("회원가입이 완료되었습니다.");

			pwr.println(name + "," + id + "," + pw);
			pwr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readFile() {

		System.out.println("로그인을 위해 아이디와 비밀번호를 입력하세요.");
		System.out.print("아이디 입력: ");
		String id = GameManager.sc.nextLine();
		System.out.print("비밀번호 입력: ");
		String pw = GameManager.sc.nextLine();
		File f = new File("data.txt");

		try (FileReader filereader = new FileReader(f); BufferedReader bufReader = new BufferedReader(filereader)) {
			String line;

			while ((line = bufReader.readLine()) != null) {
				String[] split = line.split(",");
				String storedId = split[1];
				String storedPw = split[2];

				if (storedId.equals(id) && storedPw.equals(pw)) {
					System.out.println(split[0] + "님 로그인 성공");
					access = true;
					System.out.println("=======================================================");
					break;
				}
			}

			if (access == false) {
				System.out.println("로그인 실패");
				System.out.println("=======================================================");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
