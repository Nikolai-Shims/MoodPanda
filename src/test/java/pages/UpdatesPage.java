package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;


@Log4j2
public class UpdatesPage extends BasePage {

    private static final String ALL_POST = ".rounded-top-corner";
    private static final String DELETE_POST = ".glyphicon.glyphicon-trash.ButtonDelete";

    @Step("Post Should be delete")
    public ElementsCollection deletePost(int index) {
        ElementsCollection list = $$(ALL_POST);
        log.info("Get count of myself posts: " + list.size());
        list.get(index).$(DELETE_POST).waitUntil(Condition.appear, basicTimeout).click();
        sleep(basicTimeout);
        return list;
    }

    @Step("Get count posts and validate that post was delete")
    public int getCountOfPosts() {
        ElementsCollection list2 = $$(ALL_POST);
        int amount = list2.size();
        return amount;
    }

}
