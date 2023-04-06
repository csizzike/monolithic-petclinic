/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.monolithic.petclinic.management.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Column(name = "instructions")
    private String instructions;

    @JoinColumn(name = "reporter_user_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private User reporter;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_task",
            joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id") })
    private List<User> assignees;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "completed_comment")
    private String completedComment;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public List<User> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<User> assignees) {
        this.assignees = assignees;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getCompletedComment() {
        return completedComment;
    }

    public void setCompletedComment(String completedComment) {
        this.completedComment = completedComment;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
