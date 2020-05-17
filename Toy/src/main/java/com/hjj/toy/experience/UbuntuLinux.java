package com.hjj.toy.experience;

/**
 * Ubuntu
 */
public class UbuntuLinux {

    /**
     * 卸载软件步骤
     *
     * 1. 删除软件及配置文件

     apt-get --purge remove wine
     2. 删除没用的依赖包

     apt-get autoremove wine
     3. 此时dpkg的列表中有"rc"状态的软件包,可以执行以下命令进行最后清理

     dpkg -l |grep ^rc|awk '{print $2}' |sudo xargs dpkg -P
     4. 然后删除安装包,位于/root/.wine和/home/usrname/.wine

     rm -rf /root/.wine
     rm -rf /home/usrname/.wine
     */
}
