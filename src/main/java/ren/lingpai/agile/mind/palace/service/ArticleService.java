package ren.lingpai.agile.mind.palace.service;

import java.util.List;

import ren.lingpai.agile.mind.palace.entity.ArticleDO;
import ren.lingpai.lpagile.annotation.Service;
import ren.lingpai.lpagile.part.DataBasePart;


/**
 * Created by lrp on 17-3-5.
 */
@Service
public class ArticleService {

    /**
     * 根据Type获取文章列表
     */
    public List<ArticleDO> getStarArticleList(){
        String sql = "SELECT " +
                " m_id as id , m_title as title , m_summary as summary " +
                " , m_cover_img_url as coverImgUrl , m_url as url , m_type_id as typeId " +
                " , m_sort as sort " +
                " FROM t_mind_article " +
                " where m_star= ? order by m_sort DESC";
        return DataBasePart.queryEntityList(ArticleDO.class , sql , 1);
    }

    /**
     * 根据Type获取文章列表
     */
    public List<ArticleDO> getArticleListByType(int typeId){
        String sql = "SELECT " +
                " m_id as id , m_title as title , m_summary as summary " +
                " , m_cover_img_url as coverImgUrl , m_url as url , m_type_id as typeId " +
                " , m_sort as sort " +
                " FROM t_mind_article " +
                " where m_type_id= ? order by m_sort DESC";
        return DataBasePart.queryEntityList(ArticleDO.class , sql , typeId);
    }

    /**
     * 根据Type获取文章个数
     */
    public long getArticleNumByType(int typeId){
        String sql = " SELECT count(*) " +
                " FROM t_mind_article " +
                " where m_type_id= ? ";
        return DataBasePart.query(sql , typeId);
    }

}
