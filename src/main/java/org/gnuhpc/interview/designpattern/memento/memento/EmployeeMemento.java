package org.gnuhpc.interview.designpattern.memento.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

//Memento
@Data
@AllArgsConstructor
public class EmployeeMemento {
    private String name;
    private String phone;
}
