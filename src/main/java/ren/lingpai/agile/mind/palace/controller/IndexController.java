package ren.lingpai.agile.mind.palace.controller;

import java.util.Collections;
import java.util.List;

import ren.lingpai.agile.mind.palace.entity.ArticleDO;
import ren.lingpai.agile.mind.palace.entity.TypeDO;
import ren.lingpai.agile.mind.palace.service.ArticleService;
import ren.lingpai.agile.mind.palace.service.TypeService;
import ren.lingpai.agile.mind.palace.util.RandomUtil;
import ren.lingpai.lpagile.annotation.Action;
import ren.lingpai.lpagile.annotation.Controller;
import ren.lingpai.lpagile.annotation.Get;
import ren.lingpai.lpagile.annotation.Inject;
import ren.lingpai.lpagile.entity.LPData;
import ren.lingpai.lpagile.entity.LPView;
import ren.lingpai.lputil.collection.CollectionUtil;

/**
 * @author liurenpeng
 * @date Created in 19-4-4
 */
@Controller("")
public class IndexController {

    private static final int GITHUB_TYPE_ID = -1;
    private static final int MIND_PALACE_TYPE_ID = 1;

    @Inject
    private TypeService typeService;
    @Inject
    private ArticleService articleService;

    /**
     * 进入首页
     */
    @Get
    @Action("/mind")
    public LPView mind(Integer pId) {
        if (pId == null || pId <= 0) {
            pId = MIND_PALACE_TYPE_ID;
        }
        TypeDO pType = typeService.getById(pId);
        List<TypeDO> sonTypeList = typeService.getListByPid(pId);
        StringBuilder typeSB = new StringBuilder(pType.parseRootNodeStr());
        if (CollectionUtil.isNotEmpty(sonTypeList)) {
            for (TypeDO typeDO : sonTypeList) {
                typeSB.append(typeDO.parseSonNodeStr());
            }
        }
        return new LPView("mind/index.jsp").addModel("typeStr", typeSB.toString());
    }

    /**
     * github
     */
    @Get
    @Action("/github")
    public LPView github() {
        List<ArticleDO> articleList = articleService.getArticleListByType(GITHUB_TYPE_ID);
        return new LPView("mind/list.jsp").addModel("articleList", articleList);
    }

    /**
     * 随机获取星标文章
     */
    @Get
    @Action("/random")
    public LPView randomStar(){
        List<ArticleDO> articleList =articleService.getStarArticleList();
        int size = articleList.size();
        int index = RandomUtil.nextInt(0,size);
        return new LPView("mind/list.jsp").addModel("articleList",
                Collections.singletonList(articleList.get(index)));
    }

    /**
     * 进入文章列表页
     */
    @Get
    @Action("/list")
    public LPView list(Integer typeId){
        List<ArticleDO> articleList =articleService.getArticleListByType(typeId);
        return new LPView("mind/list.jsp").addModel("articleList",articleList);
    }

    /**
     * 获取子类别数量
     */
    @Get
    @Action("/sonNum")
    public LPData sonNum(Integer pId) {
        if (pId == null || pId <= 0) {
            pId = MIND_PALACE_TYPE_ID;
        }
        return new LPData(typeService.getListByPid(pId).size());
    }

    /**
     * 获取该类别下的文章数量
     */
    @Get
    @Action("/articleNum")
    public LPData articleNum(Integer pId) {
        if (pId == null || pId <= 0) {
            pId = MIND_PALACE_TYPE_ID;
        }
        return new LPData(articleService.getArticleNumByType(pId));
    }

    /**
     * 进入404页面
     */
    @Get
    @Action("/404")
    public LPView err404(){
        return new LPView("404.jsp");
    }

}
