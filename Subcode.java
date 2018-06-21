package com.game.blastraven.b.montyhallgame;

public interface Subcode {
    //ボタンを非表示にする(テスト用)
    void disableButton();

    //プレイヤーに選択されているドアのidを返す関数
    int idSearch();

    void writeing(String score);

    void reading();

    void textChange(String name, String input, String output);

    void screenUpdate(String s);
}
//処理の移譲