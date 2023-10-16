/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.prototype;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Prototype.
 *
 * // 步骤1：创建原型类
 */
@Slf4j
public abstract class Prototype<T> implements Cloneable {

  /**
   * Object a shallow copy of this object or null if this object is not Cloneable.
   *
   * 这个通用的 copy 方法使得所有继承自 Prototype 的类都可以轻松地进行浅拷贝。
   * 浅拷贝意味着对象的基本属性会被复制，但如果对象包含引用其他对象的属性，那么引用会被复制，但实际的对象不会被克隆。
   * 这就是为什么它被称为浅拷贝。
   *
   * 你可以在具体的原型类中重写 copy 方法，以便在需要时执行深拷贝，即复制对象以及其所有关联对象的副本。
   */
  @SuppressWarnings("unchecked")
  @SneakyThrows
  public T copy() {
    return (T) super.clone();
  }
}
