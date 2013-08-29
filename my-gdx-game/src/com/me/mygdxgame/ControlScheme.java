package com.me.mygdxgame;

public final class ControlScheme {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Jump;
		result = prime * result + Left;
		result = prime * result + Right;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControlScheme other = (ControlScheme) obj;
		if (Jump != other.Jump)
			return false;
		if (Left != other.Left)
			return false;
		if (Right != other.Right)
			return false;
		return true;
	}
	public ControlScheme(int left, int right, int jump) {
		super();
		Left = left;
		Right = right;
		Jump = jump;
	}
	public int Left;
	public int Right;
	public int Jump;
}
