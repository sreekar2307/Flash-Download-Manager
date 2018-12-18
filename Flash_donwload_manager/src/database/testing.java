package database;

import java.util.ArrayList;

import models.Question;
import models.Reply;
import models.Thread;

public class testing {

	public static void main(String[] args) {
		Questions  test = new Questions();
		// Question question = test.get_Question(1);
		// System.out.println(question.getQuestion_Title());
		// System.out.println(question.getQuestion_Description());
		// System.out.println(question.getUsername());
		// ArrayList<Reply> replies = question.getReplies();
		// for(int i=0;i<replies.size();i++)
		// {
		// System.out.println(replies.get(i).getReply_description());
		// System.out.println(replies.get(i).getReplied_by());
		// System.out.println(replies.get(i).getReplied_on());
		// }
		ArrayList<Thread> Threads = test.get_Threads();
		for(int i=0;i<Threads.size();i++)
		{
			System.out.println(Threads.get(i).getQuestion_Title());
			System.out.println(Threads.get(i).getQuestion_Description());
			System.out.println(Threads.get(i).getUsername());
			System.out.println(Threads.get(i).getCreated_On());
			System.out.println(Threads.get(i).getReply_count());
			System.out.println();
			System.out.println();
		}
		
	}

}
