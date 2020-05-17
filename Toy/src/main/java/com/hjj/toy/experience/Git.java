package com.hjj.toy.experience;

/**
 * git的各种使用
 *
 *
 */
public class Git {

    /**
     * git 空间模型
     * 本地工作区-->add暂存区-->commit本地版本库-->push远端关联版本库
     *
     * 本地分支： refs/heads/ 如refs/heads/master
     * 远程分支：refs/remotes/ 如refs/remotes/origin/master
     *   其中origin是默认远程版本库的名称
     *
     * HEAD 当前分支的最近提交
     *
     * gitk可视化查看提交：1.箭头指向父提交；2.没有父提交的为初始提交；3.有多个父提交的为合并提交；
     *                   4.有多个子提交的为拉取分支；
     *
     * git分支：
     * 列出分支 git branch
     * 创建分支 git branch 分支名
     * 切换分支 git checkout 分支名
     * 创建并切换 git checkout -b 分支名
     * 删除分支 只能删除非当前分支 git branch -d 分支名
     *
     * 合并分支 git merge 分支名   在当前分支下，把（分支名代表）另一个分支合并到当前，会产生一个提交
     * 合并后未commit前还原 git reset --hard HEAD 工作区和暂存区还原到git merge 之前
     * 合并后已经commit还原 git reset --hard ORIG_HEAD Git把原始分支的HEAD保存在ORIG_HEAD
     *
     */
    /**
     * 还原
     * git reset 选项
     * --soft 版本库yes  暂存区no 工作区no
     * --mixed 版本库yes  暂存区yes 工作区no
     * --hard 版本库yes  暂存区yes 工作区yes
     *
     * git revert 版本号 还原到版本号的所有文件
     *
     * 区别：
     * git revert 会产生一个新的提交来还原； a-b-c:a-b-c-b' b'是b时的文件状态
     * git reset  修改历史版本的记录 a-b-c:a-b
     *
     */
    /**
     * 变基提交
     * git rebase master dev 将dev分支的基线移动到master分支最新提交
     * a-b-c-d-e  master                      a-b-c-d-e  master
     *    (来自b)w-x-y-z  dev    --> git rebase 后      (来自e)w'-x'-y'-z'  dev
     *
     *
     */


    /**
     * git 配置文件优先级：.git/config > ~/.gitconfig > /etc/gitconfig
     *
     * .gitignore 记录git忽略的文件模式
     *
     *
     */

    /**
     *
     * 查看当前状态 git status
     * 查看提交日志 git log --graph
     * 文件对比 git diff 文件 ：暂存区与工作区比较
     *         git diff HEAD 文件： HEAD(当前工作分支的最新提交)与工作区比较
     *         git diff --staged 文件：暂存区与HEAD比较
     *         git diff 提交id 文件：工作区与某次提交比较
     *         git diff 提交id1 提交id2 文件：提交id1与提交id2比较
     */

    /**
     * git 正向提交
     * git add 文件或. 工作区到暂存区
     * git commit -m "说明" 暂存区到本地版本库
     *
     * 删除文件
     * git rm 文件 删除文件
     * git commit -m "说明" 追踪的文件（已索引/在版本库）进行删除
     *
     * 工作区文件删除后从HEAD恢复
     * git add 文件
     * git checkout HEAD -- 文件
     *
     *
     * git commit --amend 追加到最后一次提交
     *
     */

    /**
     * 和远程版本库交互
     * git pull ==
     * git fetch 获取
     * git merge 合并
     *
     * 或选择 git fetch + git rebase
     *
     * git push 推送
     *
     *
     *
     */



    /**
     * 实际使用的评审+合并代码
     * pull request 过程
     *
     * 集中管理者工作模式（各自在自己仓库开发并提交，
     *            然后通过pull-request向管理者发送通知，
     *            管理者拉取各个开发者的仓库代码做code_review及merge）
     *
     * Pull Request的要求就是需要两个远程分支(仓库)进行合并(代码拥有者的分支和代码贡献者的分支)：
     * 拥有者分支为：
     * https://github.com/yqszt/MyBlog.git
     *
     * 1.贡献者fork拥有者代码
     * git clone https://github.com/yqszt/MyBlog.git
     * git remote add st https://github.com/SelimTeam/MyBlog.git //创建st远程仓库
     * git push -u st
     *
     * 2.贡献者在代码中修改内容并提交
     *
     * 3.贡献者使用git request-pull命令：
     * git request-pull -p 5bf2e35 https://github.com/SelimTeam/MyBlog.git master
     *
     * 其中-p 5bf2e35代表从哪次提交开始
     * url代表的是贡献者的仓库地址，
     * master 为贡献者的分支。
     *
     * 4.将pull request信息告知作者，作者将会知道贡献者的仓库地址、分支、从哪一个提交开始、哪一个提交结束，
     * 并且带有详细的变更信息。
     * 注：这里的告知是通过邮件等方式将上面request-pull命令生成的信息发送给作者
     * github等平台上提供的pull request功能是由平台自己实现的通知方式
     *
     * 5.作者添加贡献者的远程仓库，获取并将更新合并到主分支
     * git remote add selimteam https://github.com/SelimTeam/MyBlog.git
     * git fetch selimteam master
     * git merge selimteam/master
     * git push
     *
     *
     */

}
