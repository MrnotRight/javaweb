package blog.utils;

import java.util.List;

import blog.model.Article;

/**
 * 鏂囩珷澶勭悊宸ュ叿
 * 
 */
public class ArticleUtils {

	/**
	 * 澶勭悊涓嬫椂闂�
	 * 
	 * @param list
	 * @return
	 */
	public static List cutTime(List<Article> list) {

		for (Article a : list) {
			a.setTime(a.getTime().substring(0, 11));
		}

		return list;
	}

	/**
	 * 澶勭悊涓嬫椂闂�
	 * 
	 * @param Article
	 * @return
	 */
	public static Article cutTime(Article a) {
		a.setTime(a.getTime().substring(0, 11));
		return a;
	}

	/**
	 * 澶勭悊涓嬫枃绔犲唴瀹�
	 * 
	 * @param list
	 * @return
	 */
	public static List cutContent(List<Article> list) {

		for (Article a : list) {
			if (a.getContent() != null && a.getContent().length() > 351) {
				a.setContent(a.getContent().substring(0, 349) + "...");
			}
		}
		return list;
	}


}
