Bowling

given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game.

<1>Each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.

10 frames

<2>In each frame, the bowler gets up to two tries to knock down all the pin

每次frames中有两次机会来击倒所有

<1>两次都没有击倒所有,则得分是两次击倒的球的总数

<2>两次击倒所有,叫spare, ten + 下一次击倒的球数量(in his next turn)

<3>第一次全击倒,叫strike, ten + 下两次击倒的球数量

<4>当为spare,strike时,到10次的时候,则多一次或两次机会,过程不会在重复

任务分级

1.获取得分  Game getTotalScore(rolls)

<1>10轮(frames) 每一轮(frame)两次(two tries)都没有击中 

-- -- -- -- -- -- -- -- -- --   0分  ok

<2>每轮两次都没全击倒

9- 9- 9- 9- 9- 9- 9- 9- 9- 9-  90分  ok

8- 7- 6- 5- 4- 3- 2- 1- 5- 5-  46分  ok

-5 -7 6- -5 -5 3- 2- 1- -5 5-  46分  ok

11 11 11 11 11 11 11 11 11 11  20分[补充]

<2>每轮一次全中(strike),加两次都全中

X X X X X X X X X X X X 300分

<3>10轮 每轮两次都全中(spare)

5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/

<3-1>最后一次全中
 X  155

<3-2>最后一次5

 5  150