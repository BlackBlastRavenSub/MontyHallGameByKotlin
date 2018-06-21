package com.game.blastraven.b.montyhallgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GameCoreActivity : AppCompatActivity() {
    //インターフェイスの実装と処理の記述
    internal var subcode: Subcode = object : Subcode {
        //interface Subcodeのオーバーライド
        override fun disableButton() {
            DoorButton1.visibility = View.INVISIBLE
        }

        //interface Subcodeのオーバーライド
        override fun idSearch(): Int {
            var id = 0
            for (i in 0..98) {
                if (door[i].choose == true) {
                    id = door[i].id
                }
            }
            return id
        }

        override fun writeing(finalscore: String) {
            database.writeing(finalscore)
        }

        override fun reading() {
            database.reading()
        }

        override fun textChange(name: String, input: String, output: String) {
            //TextView name = findViewById(R.id.output);
            //name.setText(R.string.input);
        }

        override fun screenUpdate(s: String) {
            //どう書こう・・・？

        }
        //何かのデータを送ったらそれを適用して画面を更新できるようにしたい!
    }
    internal var database: Database
    internal var game = Game(subcode)
    internal var door = arrayOfNulls<Door>(100)
    //画面テキストを変更するためにテキストビューを指定
    internal var game_core: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        database = Database(this)
        for (i in 0..98) {
            door[i] = Door(i + 1, subcode)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_core)
        //bootstrapのドアをプログラムから制御するために名前付け(続き)
        DoorButton1 = findViewById(R.id.DoorButton1)
        DoorButton2 = findViewById(R.id.DoorButton2)
        DoorButton3 = findViewById(R.id.DoorButton3)
        DoorButton4 = findViewById(R.id.DoorButton4)
        DoorButton5 = findViewById(R.id.DoorButton5)
        DoorButton6 = findViewById(R.id.DoorButton6)
        DoorButton7 = findViewById(R.id.DoorButton7)
        DoorButton8 = findViewById(R.id.DoorButton8)
        DoorButton9 = findViewById(R.id.DoorButton9)
        DoorButton10 = findViewById(R.id.DoorButton10)
        game_core = this.findViewById(R.id.textView)
        val game_core_view = getString(R.string.game_core, game.select)
        game_core.text = game_core_view
        when (game.stage) {
            "start" -> game.`GameStart$production_sources_for_module_app`()
            "Firstchoice" -> game.`FirstChoice$production_sources_for_module_app`()
            "Finalchoice" -> game.`FinalChoice$production_sources_for_module_app`()
            "StageClear" -> game.`StageClear$production_sources_for_module_app`()
            "GameOver" -> game.`GameOver$production_sources_for_module_app`()
            "GameSet" -> game.`GameSet$production_sources_for_module_app`()
        }

    }

    //public void writeing(View view) {game_core.setText(Database.reading());}

    internal fun screenUpdate() {
        val game_core_setview = getString(R.string.game_core, game.select)
        game_core.text = game_core_setview
    }

    //各ボタンを押したときの動作
    //ドアボタン
    fun buttonclick(view: View) {
        //共通の処理
        for (i in 0..98) {
            door[i].choose = false
        }
        //押されたボタンごとに個別の動作
        when (view.id) {

            R.id.DoorButton1 -> {
                door[0].choose = true
                database.writeing("Door1")

                //テスト
                game.`test$production_sources_for_module_app`(DoorButton1)
            }
            R.id.DoorButton2 -> door[1].choose = true
            R.id.DoorButton3 -> door[2].choose = true
            R.id.DoorButton4 -> door[3].choose = true
            R.id.DoorButton5 -> door[4].choose = true
            R.id.DoorButton6 -> door[5].choose = true
            R.id.DoorButton7 -> door[6].choose = true
            R.id.DoorButton8 -> door[7].choose = true
            R.id.DoorButton9 -> door[8].choose = true
            R.id.DoorButton10 -> door[9].choose = true
        }
        //共通の処理
        game.select = subcode.idSearch()
        screenUpdate()
    }

    //書き込み/読み込みボタン(テスト用)
    fun database(view: View) {
        when (view.id) {
            R.id.writeing -> database.writeing("Dummy")
            R.id.reading ->
                //database.reading();
                Toast.makeText(this, database.reading(), Toast.LENGTH_LONG).show()
        }
    }

    //ボタンの色をもとに戻す
    internal fun buttonColorReset() {}

    companion object {
        //bootstrapのドアをプログラムから制御するために名前付け
        internal var DoorButton1: Button
        internal var DoorButton2: Button
        internal var DoorButton3: Button
        internal var DoorButton4: Button
        internal var DoorButton5: Button
        internal var DoorButton6: Button
        internal var DoorButton7: Button
        internal var DoorButton8: Button
        internal var DoorButton9: Button
        internal var DoorButton10: Button
    }

    //画面表示の変更
    /*
    public void textChange(String input, String put) {
        TextView textSet = findViewById(R.id.output);
        textSet.setText(R.string.input);
    }
    */
}