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
package com.iluwatar.singleton;

/**
 * <p>Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization
 * mechanism.</p>
 *
 */
public final class ThreadSafeLazyLoadedIvoryTower {

  /**
   * Singleton instance of the class, declared as volatile to ensure atomic access by multiple threads.
   *
   *静态成员变量 instance 被声明为 volatile，类加载时，instance 变量会被分配内存空间，但它的值是 null, 在第一次调用 getInstance() 方法时才会被初始化。
   *
   * volatile 可以确保一个变量的修改对所有线程都是可见的
   */
  private static volatile ThreadSafeLazyLoadedIvoryTower instance;

  /**
   * Private constructor to prevent instantiation from outside the class.
   */
  private ThreadSafeLazyLoadedIvoryTower() {
    // Protect against instantiation via reflection
    if (instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * The instance doesn't get created until the method is called for the first time.
   *
   * @return an instance of the class.
   *
   * instance 是在类加载时不会被创建的，因为它是一个静态成员变量，只有在第一次调用 getInstance() 方法时，才会检查 instance 是否为 null。
   * 如果 instance 为 null，则才创建新的 ThreadSafeLazyLoadedIvoryTower 对象。
   * 因此，虽然这个实现在第一次调用 getInstance() 之前不会创建实例，但在第一次调用后，它将保持创建的实例，因此它仍然被称为懒加载单例。
   */
  public static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {
    if (instance == null) {
      instance = new ThreadSafeLazyLoadedIvoryTower();
    }
    return instance;
  }
}
