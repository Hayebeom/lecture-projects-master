package com.sample.school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sample.school.service.SchoolService;
import com.sample.school.service.SchoolServiceImple;

public class SchoolApp {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private static int nextInt() {
		try {
			String text = in.readLine();
			return Integer.parseInt(text);
		} catch (IOException e) {
			return 0;
		}
	}
	
	private static String next() {
		try {
			return in.readLine();
		} catch (IOException e) {
			return "";
		}
	}
	
	public static void main(String[] args) {
		SchoolService service = new SchoolServiceImple();
		
		while (true) {
			System.out.println("=====================================================================");
			System.out.println("1.교수 2.학생 0.종료");
			System.out.println("=====================================================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = nextInt();
			
			if (menuNo == 1) {
				System.out.println("=====================================================================");
				System.out.println("1.교수등록 2.과목등록 3.과목조회 4.과정등록 5.과정조회 6.신청자조회 7.성적입력");
				System.out.println("=====================================================================");
				
				System.out.println("메뉴를 선택하세요: ");
				int profMenuNo = nextInt();
				
				if (profMenuNo == 1) {
					System.out.println("[신규 교수 등록]");
				} else if (profMenuNo == 2) {
					System.out.println("[신규 과목 등록]");
					
				} else if (profMenuNo == 3) {
					System.out.println("[과목조회]");
					
					System.out.print("교수번호를 입력하세요: ");
					int professorNo = nextInt();
							
					service.printSubjectByProfessorNo(professorNo);
				} else if (profMenuNo == 4) {
					System.out.println("[신규 개설과정 등록]");
					
				} else if (profMenuNo == 5) {
					System.out.println("[개설과정 조회]");
					
				} else if (profMenuNo == 6) {
					System.out.println("[개설과정별 신청자 현황 조회]");
					
				} else if (profMenuNo == 7) {
					System.out.println("[성적입력]");
					
				}
			} else if (menuNo == 2) {
				System.out.println("=====================================================================");
				System.out.println("1.학생등록 2.과정등록 3.수강신청 4.수강신청현황조회 5.수강취소 6.성적조회");
				System.out.println("=====================================================================");
				
			} else if (menuNo == 0) {
				break;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}
		
	}
	
}
