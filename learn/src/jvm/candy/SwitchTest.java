// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SwitchTest.java

package jvm.candy;

import java.io.PrintStream;

public class SwitchTest
{

	public SwitchTest()
	{
	}

	public static void Method1(String s)
	{
		String s1 = s;
		byte byte0 = -1;
		switch (s1.hashCode())
		{
		case 97: // 'a'
			if (s1.equals("a"))
				byte0 = 0;
			break;

		case 98: // 'b'
			if (s1.equals("b"))
				byte0 = 1;
			break;
		}
		switch (byte0)
		{
		case 0: // '\0'
			System.out.println("1");
			break;

		case 1: // '\001'
			System.out.println("2");
			break;
		}
	}
}
