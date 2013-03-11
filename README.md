Name Tag API
===========

How to use the Name Tag API.

<h3>Using the Event</h3>
<pre>
public void onTagReceive(NameTagReceiveEvent event) {
	event.setNameTag(ChatColor.COLOR + event.getPlayer());
}
</pre>

<h3>Using the Method</h3>
<pre>
PlayerTag tag = new PlayerTag(player);
tag.setNameTag(ChatColor.COLOR + player.getName());
</pre>

Along with the method shown above,
<pre>
.setNameTag(ChatColor.COLOR + player.getName());
</pre>

There is also a color set method,
<pre>
.setNameColor(ChatColor.COLOR);
</pre>

Or, if you're British (such as myself), you can use this,

<pre>
.setNameColour(ChatColor.COLOUR);
</pre>
