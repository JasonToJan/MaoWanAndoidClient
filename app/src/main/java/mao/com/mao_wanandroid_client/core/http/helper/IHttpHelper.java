package mao.com.mao_wanandroid_client.core.http.helper;

import java.util.List;

import io.reactivex.Observable;
import mao.com.mao_wanandroid_client.model.ResponseBody;
import mao.com.mao_wanandroid_client.model.banner.HomePageBannerModel;
import mao.com.mao_wanandroid_client.model.frienduser.FriendUseWebData;
import mao.com.mao_wanandroid_client.model.home.HomeArticleListData;
import mao.com.mao_wanandroid_client.model.login.LoginData;
import mao.com.mao_wanandroid_client.model.navigation.NavigationListData;
import mao.com.mao_wanandroid_client.model.project.ProjectClassifyData;
import mao.com.mao_wanandroid_client.model.project.ProjectListData;
import mao.com.mao_wanandroid_client.model.search.HotKeyData;
import mao.com.mao_wanandroid_client.model.tree.KnowledgeHierarchyData;
import mao.com.mao_wanandroid_client.model.webmark.webBookMark;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * @author maoqitian
 * @Description 网络请求帮助接口
 * @Time 2018/11/12 0012 20:23
 */
public interface IHttpHelper {

    /**
     * 获取首页文章数据列表
     * @param pageNum 页码 从0开始
     * @return
     */
    Observable<ResponseBody<HomeArticleListData>>HomeArticleListData(int pageNum);
    /**
     * 获取首页Banner数据
     * @return
     */
    Observable<ResponseBody<List<HomePageBannerModel>>> GetHomePageBannerData();
    /**
     * 获取常用网站数据
     * @return
     */
    Observable<ResponseBody<List<FriendUseWebData>>>GetFriendUseWebData();
    /**
     * 搜索热词
     * @return
     */
    Observable<ResponseBody<List<HotKeyData>>>GetHotKeyData();
    /**
     * 知识体系数据
     * @return
     */
    Observable<ResponseBody<List<KnowledgeHierarchyData>>> getKnowledgeHierarchyData();
    /**
     * 根据知识体系 id 获取知识体系下的文章
     * @param pageNum 页码：拼接在链接上，从0开始
     * @param cid 分类的id 上述二级目录的id
     * @return
     */
    Observable<ResponseBody<HomeArticleListData>> getKnowledgeTreeDetialData(int pageNum,int cid);
    /**
     * 获取导航数据(网站 个人博客 社区等网站导航数据)
     * @return
     */
    Observable<ResponseBody<NavigationListData>>getNavigationListData();
    /**
     * 项目分类 项目为包含一个分类，该接口返回整个分类。
     * @return
     */
    Observable<ResponseBody<List<ProjectClassifyData>>>getProjectClassifyData();
    /**
     * 项目列表数据 某一个分类下项目列表数据，分页展示
     * @param pageNum 拼接在链接中，从1开始。
     * @param cid 分类的id，上面项目分类接口
     * @return
     */
    Observable<ResponseBody<ProjectListData>> getProjectListData(int pageNum, int cid);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Observable<ResponseBody<LoginData>> postLoginData(String username, String password);
    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param repassword 确认密码
     * @return
     */
    Observable<ResponseBody<LoginData>> postRegisterData(
            String username, String password, String repassword
    );

    /**
     * 退出登录
     * @return
     */
    Observable<ResponseBody<String>> getLoginOut();
    /**
     * 收藏文章列表
     * @param pageNum 页码：拼接在链接中，从0开始。
     * @return
     */
    Observable<ResponseBody<HomeArticleListData>>getCollectListData(int pageNum);
    /**
     * 收藏站内文章
     * @param articleId 文章id，拼接在链接中。
     * @return
     */
    Observable<ResponseBody<HomeArticleListData>>getCollectInsideListData(int articleId);
    /**
     * 收藏站外文章
     * @param title
     * @param author
     * @param link
     * @return
     */
    Observable<ResponseBody<HomeArticleListData>>getCollectOutsideListData(
            String title, String author, String link);
    /**
     * 文章列表 取消收藏
     * @param articleId 文章id:拼接在链接上
     * @return
     */
    Observable<ResponseBody<HomeArticleListData>>cancelCollectArticleListData(int articleId);

    /**
     * 我的收藏页面 取消收藏（该页面包含自己录入的内容）
     * @param articleId 文章id:拼接在链接上
     * @param originId  originId:列表页下发，无则为-1 （originId 代表的是你收藏之前的那篇文章本身的id； 但是收藏支持主动添加，这种情况下，没有originId则为-1）
     * @return
     */
    Observable<ResponseBody<HomeArticleListData>>cancelCollectArticlePageData(
            int articleId, int originId
    );
    /**
     * 获取收藏网站列表
     */
    Observable<ResponseBody<List<webBookMark>>> getWebBookMark();
    /**
     * 添加收藏网址
     * @param name 网站名称
     * @param link 网站链接
     * @return
     */
    Observable<ResponseBody<webBookMark>> addWebBookMark(
            String name, String link);
    /**
     * 编辑收藏网站
     * @param id 收藏网站 id
     * @param name 网站名称
     * @param link 网站链接
     * @return
     */
    Observable<ResponseBody<webBookMark>> updateWebBookMark(
            String id, String name, String link);

    /**
     * 删除收藏网站
     * @param id 收藏网站 id
     * @return
     */
    Observable<ResponseBody> deleteWebBookMark(
            String id);
    /**
     * 搜索
     * @param pageNum 页码：拼接在链接上，从0开始
     * @param keyWord 搜索关键词
     * @return
     */
    Observable<ResponseBody<ProjectListData>> getSearchKeyWordData(
             int pageNum, String keyWord
    );
}