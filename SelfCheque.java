/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Time;
import java.util.*;

class SelfCheque extends Cheque
{

    public SelfCheque(String chequeNumber, Boolean approval, Cashier approvedBy, double amount, Date datee, Time timee, String num, Account account) {
        super(chequeNumber, approval, approvedBy, amount, datee, timee, num, account);
    }


}